package com.softuni.mobilele.util;

import com.softuni.mobilele.model.entity.*;
import com.softuni.mobilele.model.enums.CategoryEnum;
import com.softuni.mobilele.model.enums.EngineEnum;
import com.softuni.mobilele.model.enums.TransmissionEnum;
import com.softuni.mobilele.model.enums.UserRoleEnum;
import com.softuni.mobilele.repository.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TestDataUtils {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public TestDataUtils(UserRepository userRepository, UserRoleRepository userRoleRepository, OfferRepository offerRepository, ModelRepository modelRepository, BrandRepository brandRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }


    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            UserRoleEntity userRole = new UserRoleEntity();

            adminRole.setUserRole(UserRoleEnum.ADMIN);
            userRole.setUserRole(UserRoleEnum.USER);

            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);
        }
    }

    public UserEntity createTestAdmin(String email) {

        initRoles();

            UserEntity admin = new UserEntity();
            admin.setEmail(email);
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setPassword("password");
            admin.setActive(true);
            admin.setUserRoles(userRoleRepository.findAll());

        return userRepository.save(admin);
    }

    public UserEntity createTestUser(String email) {

        initRoles();

        UserEntity user = new UserEntity();
            user.setEmail(email);
            user.setFirstName("User");
            user.setLastName("Userov");
            user.setPassword("password");
            user.setActive(true);
            user.setUserRoles(userRoleRepository.
                    findAll().stream().
                    filter(r -> r.getUserRole() != UserRoleEnum.ADMIN).
                    toList());

        return userRepository.save(user);
    }

    public OfferEntity createTestOffer(UserEntity user,
                                       ModelEntity model) {

            OfferEntity offer = new OfferEntity();
            offer.setEngine(EngineEnum.GASOLINE);
            offer.setModel(model);
            offer.setDescription("Test description");
            offer.setSeller(user);
            offer.setMileage(10000);
            offer.setTransmission(TransmissionEnum.MANUAL);
            offer.setPrice(BigDecimal.TEN);
            offer.setYear(2000);

        return offerRepository.save(offer);
    }

    public BrandEntity createTestBrand() {

        BrandEntity brand = new BrandEntity();
        brand.setName("Ford");

        return brandRepository.save(brand);
    }

    public ModelEntity createTestModel(BrandEntity brand) {

            ModelEntity model = new ModelEntity();
            model.setName("Fiesta");
            model.setBrand(brand);
            model.setImageUrl("http://image.com/image.png");
            model.setCategory(CategoryEnum.CAR);
            model.setStartYear(1978);

        return modelRepository.save(model);
    }

    public void cleanUpDatabase() {
        offerRepository.deleteAll();
        userRepository.deleteAll();
        userRoleRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }
}
