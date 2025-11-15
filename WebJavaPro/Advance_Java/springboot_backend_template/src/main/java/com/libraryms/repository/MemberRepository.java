
package com.libraryms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryms.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
