 package eu.circletouch.users.services;

import eu.circletouch.users.beans.Company;
import eu.circletouch.users.beans.CompanyRole;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.beans.UsersGroup;
import eu.circletouch.users.entities.*;
import eu.circletouch.users.exceptions.CustomException;
import eu.circletouch.users.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final BUtentiRepository bUtentiRepository;
    private final IUtentiGruppiSediRepository iUtentiGruppiSediRepository;
    private final IUtentiClientiRepository iUtentiClientiRepository;
    private final BClientiRepository bClientiRepository;
    private final IClientiRuoliRepository iClientiRuoliRepository;
    private final BRuoliRepository bRuoliRepository;

    public UsersService(BUtentiRepository bUtentiRepository, IUtentiGruppiSediRepository iUtentiGruppiSediRepository, IUtentiClientiRepository iUtentiClientiRepository, BClientiRepository bClientiRepository, IClientiRuoliRepository iClientiRuoliRepository, BRuoliRepository bRuoliRepository) {
        this.bUtentiRepository = bUtentiRepository;
        this.iUtentiGruppiSediRepository = iUtentiGruppiSediRepository;
        this.iUtentiClientiRepository = iUtentiClientiRepository;
        this.bClientiRepository = bClientiRepository;
        this.iClientiRuoliRepository = iClientiRuoliRepository;
        this.bRuoliRepository = bRuoliRepository;
    }

    public User getUser(Long id) {
        Optional<BUtentiEntity> bUtentiEntityOptional = bUtentiRepository.findById(Math.toIntExact(id));
        if (bUtentiEntityOptional.isPresent()) {
            BUtentiEntity bUtentiEntity = bUtentiEntityOptional.get();
            User user = getUser(bUtentiEntity);
            List<IUtentiGruppiSediEntity> iUtentiGruppiSediEntityList = iUtentiGruppiSediRepository.findAllByBUtentiId(bUtentiEntity.getbUtentiId());
            for (IUtentiGruppiSediEntity iUtentiGruppiSediEntity: iUtentiGruppiSediEntityList) {
                user.getGroups().add(getUsersGroup(iUtentiGruppiSediEntity.getbGruppiEntity()));
            }
            return user;
        } else {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }
    }

    public User getUser(BUtentiEntity bUtentiEntity) {
        User user = new User();
        user.setId(Long.valueOf(bUtentiEntity.getbUtentiId()));
        user.setUsername(bUtentiEntity.getCodutente());
        user.setFirstName(bUtentiEntity.getNome());
        user.setLastName(bUtentiEntity.getCognome());
        user.setEmail(bUtentiEntity.getEmail());
        user.setCompany(getCompanyFromUser(user.getId()));
        if (user.getCompany() != null)
            user.setCompanyId(user.getCompany().getId());
        return user;
    }

    private Company getCompanyFromUser(Long id) {
        Company result = null;
        List<IUtentiClientiEntity> iUtentiClientiEntityList = iUtentiClientiRepository.findAllBybUtentiId(Math.toIntExact(id));
        for (IUtentiClientiEntity iUtentiClientiEntity: iUtentiClientiEntityList) {
            Optional<BClientiEntity> optionalBClientiEntity = bClientiRepository.findById(iUtentiClientiEntity.getbClientiId());
            if (optionalBClientiEntity.isPresent()) {
                result = getCompany(optionalBClientiEntity.get());
            }
        }
        return result;
    }

    private Company getCompany(BClientiEntity bClientiEntity) {
        Company company = new Company();
        company.setId(Long.valueOf(bClientiEntity.getId()));
        company.setCode(bClientiEntity.getCodice());
        company.setName(bClientiEntity.getRagioneSociale());
        company.setVatNumber(bClientiEntity.getPartitaIva());
        company.setCompanyRoles(getCompanyRoleList(company.getId()));
        return company;
    }

    private List<CompanyRole> getCompanyRoleList(Long companyId) {
        List<CompanyRole> companyRoleList = new LinkedList<>();
        List<IClientiRuoliEntity> iClientiRuoliEntityList = iClientiRuoliRepository.findAllBybClientiId(Math.toIntExact(companyId));
        for (IClientiRuoliEntity iClientiRuoliEntity: iClientiRuoliEntityList) {
            Optional<BRuoliEntity> optionalBRuoliEntity = bRuoliRepository.findById(iClientiRuoliEntity.getbRuoliId());
            optionalBRuoliEntity.ifPresent(bRuoliEntity -> companyRoleList.add(getCompanyRole(bRuoliEntity)));
        }
        return companyRoleList;
    }

    private CompanyRole getCompanyRole(BRuoliEntity bRuoliEntity) {
        CompanyRole companyRole = new CompanyRole();
        companyRole.setId(Long.valueOf(bRuoliEntity.getId()));
        companyRole.setDescription(bRuoliEntity.getDescrizione());
        return companyRole;
    }

    public UsersGroup getUsersGroup(BGruppiEntity bGruppiEntity) {
        UsersGroup usersGroup = new UsersGroup();
        usersGroup.setId(Long.valueOf(bGruppiEntity.getbGruppiId()));
        usersGroup.setCodice(bGruppiEntity.getCodgruppo());
        usersGroup.setDescrizione(bGruppiEntity.getDesgruppo());
        return usersGroup;
    }

    public User getByUsername(String username) {
        User user = null;
        Optional<BUtentiEntity> optionalUserEntity = bUtentiRepository.findFirstByCodutente(username);
        if (optionalUserEntity.isPresent()) {
            BUtentiEntity usersEntity = optionalUserEntity.get();
            user = getUser(usersEntity);
            List<IUtentiGruppiSediEntity> iUtentiGruppiSediEntityList = iUtentiGruppiSediRepository.findAllByBUtentiId(usersEntity.getbUtentiId());
            for (IUtentiGruppiSediEntity iUtentiGruppiSediEntity: iUtentiGruppiSediEntityList) {
                user.getGroups().add(getUsersGroup(iUtentiGruppiSediEntity.getbGruppiEntity()));
            }
        }
        return user;
    }

    public String getUserEncodedPassword(Long id) {
        String password = null;
        Optional<BUtentiEntity> optionalUserEntity = bUtentiRepository.findById(Math.toIntExact(id));
        if (optionalUserEntity.isPresent()) {
            password = optionalUserEntity.get().getPassword();
        }
        return password;
    }

    public String getUserEncodedPassword(String username) {
        String password = null;
        BUtentiEntity user = new BUtentiEntity();
        user.setbUtentiId(1);
        user.setCodutente("test");
        user.setPassword("5f4dcc3b5aa765d61d8327deb882cf99");
        bUtentiRepository.save(user);
        Optional<BUtentiEntity> optionalUserEntity = bUtentiRepository.findFirstByCodutente(username);
        if (optionalUserEntity.isPresent()) {
            password = optionalUserEntity.get().getPassword();
        }
        return password;
    }
}
