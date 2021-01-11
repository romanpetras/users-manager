 package eu.circletouch.users.services;

 import eu.circletouch.commons.beans.BrowseRequest;
 import eu.circletouch.commons.beans.BrowseResponse;
 import eu.circletouch.users.beans.User;
 import eu.circletouch.users.beans.UsersGroup;
 import eu.circletouch.users.entities.*;
 import eu.circletouch.users.exceptions.CustomException;
 import eu.circletouch.users.repositories.UsersRepository;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;

 import java.util.Optional;

 @Service
 public class UsersService {

     private final UsersRepository usersRepository;
     private final CompaniesService companiesService;

     public UsersService(UsersRepository usersRepository, CompaniesService companiesService) {
         this.usersRepository = usersRepository;
         this.companiesService = companiesService;
     }

     public User getUser(Integer id) {
         Optional<UserEntity> optionalUsersEntity = usersRepository.findById(id);
         if (optionalUsersEntity.isPresent()) {
             UserEntity userEntity = optionalUsersEntity.get();
             return getUser(userEntity);
         } else {
             throw new CustomException("User not found", HttpStatus.NOT_FOUND);
         }
     }

     public User getUser(UserEntity userEntity) {
         User user = new User();
         user.setId(Long.valueOf(userEntity.getId()));
         user.setUsername(userEntity.getUsername());
         user.setFirstName(userEntity.getFirstName());
         user.setLastName(userEntity.getLastName());
         user.setEmail(userEntity.getEmail());

         if (userEntity.getCompany() != null) {
             user.setCompany(companiesService.getCompany(userEntity.getCompany()));
         }

         for (UserGroupEntity userGroupEntity : userEntity.getUserGroups()) {
             GroupEntity group = userGroupEntity.getGroup();
             UsersGroup usersGroup = getUsersGroup(group);
             user.getGroups().add(usersGroup);
         }
         return user;
     }

     private UsersGroup getUsersGroup(GroupEntity group) {
         UsersGroup usersGroup = new UsersGroup();
         usersGroup.setId(group.getId());
         usersGroup.setCode(group.getCode());
         usersGroup.setDescription(group.getDescription());
         return usersGroup;
     }

     public User getByUsername(String username) {
         User user = null;
         Optional<UserEntity> firstByUsername = usersRepository.findFirstByUsername(username);
         if (firstByUsername.isPresent()) {
             UserEntity userEntity = firstByUsername.get();
             user = getUser(userEntity);
         }
         return user;
     }

     public String getUserEncodedPassword(Integer id) {
         String password = null;
         Optional<UserEntity> firstByUsername = usersRepository.findById(id);
         if (firstByUsername.isPresent()) {
             password = firstByUsername.get().getPasswordHash();
         }
         return password;
     }

     public String getUserEncodedPassword(String username) {
         String password = null;
         Optional<UserEntity> firstByUsername = usersRepository.findFirstByUsername(username);
         if (firstByUsername.isPresent()) {
             password = firstByUsername.get().getPasswordHash();
         }
         return password;
     }

     public BrowseResponse<User> browse(BrowseRequest browseRequest, User req) {
         return null;
     }

     public User create(User event, User req) {
         return null;
     }

     public User update(Integer id, User event, User req) {
         return null;
     }

     public void delete(Integer id, User req) {

     }
 }
