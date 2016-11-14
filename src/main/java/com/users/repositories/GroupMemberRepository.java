package com.users.repositories;



import java.util.List;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.beans.GroupMembers;

public interface GroupMemberRepository extends CrudRepository<GroupMembers, Long> {

	List<GroupMembers> findByGroupId(long groupId);

}
