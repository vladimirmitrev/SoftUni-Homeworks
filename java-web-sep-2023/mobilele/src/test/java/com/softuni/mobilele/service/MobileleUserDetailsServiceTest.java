package com.softuni.mobilele.service;

import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.model.entity.UserRoleEntity;
import com.softuni.mobilele.model.enums.UserRoleEnum;
import com.softuni.mobilele.model.user.MobileleUserDetails;
import com.softuni.mobilele.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MobileleUserDetailsServiceTest {

    private MobileleUserDetailsService toTest;

    @Mock
    private UserRepository mockUserRepo;


    @BeforeEach
    void setUP() {
        toTest = new MobileleUserDetailsService(mockUserRepo);
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        //arrange
        UserEntity testUserEntity = new UserEntity();

        UserRoleEntity testUserRoleEntity1 = new UserRoleEntity();
        testUserRoleEntity1.setUserRole(UserRoleEnum.ADMIN);

        UserRoleEntity testUserRoleEntity2 = new UserRoleEntity();
        testUserRoleEntity2.setUserRole(UserRoleEnum.USER);


        testUserEntity.setEmail("email@example.com");
        testUserEntity.setPassword("topsecret");
        testUserEntity.setFirstName("Ivan");
        testUserEntity.setLastName("Ivanov");
        testUserEntity.setActive(true);
        testUserEntity.setImageUrl("http://image.com/image");
        testUserEntity.setUserRoles(List.of(
                testUserRoleEntity1, testUserRoleEntity2));

        when(mockUserRepo.findByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));
        //act
        MobileleUserDetails userDetails =
                (MobileleUserDetails) toTest.loadUserByUsername(testUserEntity.getEmail());

        //assert
        Assertions.assertEquals(testUserEntity.getEmail(),
                userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(testUserEntity.getFirstName() + " " + testUserEntity.getLastName(),
                userDetails.getFullName());

        var authorities = userDetails.getAuthorities();

        Assertions.assertEquals(2, authorities.size());

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals("ROLE_" + UserRoleEnum.ADMIN.name(),
                authoritiesIter.next().getAuthority());

        Assertions.assertEquals("ROLE_" + UserRoleEnum.USER.name(),
                authoritiesIter.next().getAuthority());

    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {

        // arrange
        // NOTE: No need to arrange anything, mocks return empty optionals.

        // act && assert
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername("non-existent@example.com"));
    }
}
