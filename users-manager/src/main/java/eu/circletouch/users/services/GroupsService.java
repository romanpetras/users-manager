package eu.circletouch.users.services;

import eu.circletouch.commons.beans.BrowseRequest;
import eu.circletouch.commons.beans.BrowseResponse;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.beans.UsersGroup;
import eu.circletouch.users.entities.GroupEntity;
import eu.circletouch.users.entities.UserGroupEntity;
import eu.circletouch.users.exceptions.CustomException;
import eu.circletouch.users.repositories.GroupsRepository;
import eu.circletouch.users.repositories.UsersGroupsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsService {

    private final GroupsRepository groupsRepository;
    private final UsersGroupsRepository usersGroupsRepository;

    public GroupsService(GroupsRepository groupsRepository, UsersGroupsRepository usersGroupsRepository) {
        this.groupsRepository = groupsRepository;
        this.usersGroupsRepository = usersGroupsRepository;
    }

    public UsersGroup get(Integer id, User req) {
        Optional<GroupEntity> optionalGroupEntity = groupsRepository.findById(id);
        if (optionalGroupEntity.isPresent()) {
            GroupEntity groupEntity = optionalGroupEntity.get();
            return getUsersGroup(groupEntity);
        } else {
            throw new CustomException("Group not found for id " + id, HttpStatus.NOT_FOUND);
        }
    }

    public BrowseResponse<UsersGroup> browse(BrowseRequest browseRequest, User req) {
        return null;
    }

    public UsersGroup create(UsersGroup usersGroup, User req) {
        Optional<GroupEntity> firstByCode = groupsRepository.findFirstByCode(usersGroup.getCode());
        if (firstByCode.isPresent()) {
            throw new CustomException("Group already exists for code " + usersGroup.getCode(), HttpStatus.BAD_REQUEST);
        }

        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setCode(usersGroup.getCode());
        groupEntity.setDescription(usersGroup.getDescription());
        groupEntity.setCreatedById(req.getId());
        groupEntity.setCreatedByUser(req.getUsername());
        groupEntity = groupsRepository.save(groupEntity);
        return get(groupEntity.getId(), req);
    }

    public UsersGroup update(Integer id, UsersGroup usersGroup, User req) {
        Optional<GroupEntity> optionalGroupEntity = groupsRepository.findById(id);
        if (optionalGroupEntity.isPresent()) {
            GroupEntity groupEntity = optionalGroupEntity.get();
            groupEntity.setCode(usersGroup.getCode());
            groupEntity.setDescription(usersGroup.getDescription());
            groupEntity.setUpdatedById(req.getId());
            groupEntity.setUpdatedByUser(req.getUsername());
            groupEntity = groupsRepository.save(groupEntity);
            return get(id, req);
        } else {
            throw new CustomException("Group not found for id " + id, HttpStatus.NOT_FOUND);
        }
    }

    public void delete(Integer id, User req) {
        Optional<GroupEntity> optionalGroupEntity = groupsRepository.findById(id);
        if (optionalGroupEntity.isPresent()) {
            List<UserGroupEntity> allByGroupId = usersGroupsRepository.findAllByGroupId(id);
            if (allByGroupId.size() > 0) {
                throw new CustomException("Group in use", HttpStatus.PRECONDITION_REQUIRED);
            } else {
                groupsRepository.deleteById(id);
            }
        } else {
            throw new CustomException("Group not found for id " + id, HttpStatus.NOT_FOUND);
        }
    }

    protected UsersGroup getUsersGroup(GroupEntity groupEntity) {
        UsersGroup usersGroup = new UsersGroup();
        usersGroup.setId(groupEntity.getId());
        usersGroup.setCode(groupEntity.getCode());
        usersGroup.setDescription(groupEntity.getDescription());
        return usersGroup;
    }
}
