
package com.domain.alif.iam.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRoleModel, Long> {
    PersonRoleModel findByPersonRoleName(String personRoleName);
}
