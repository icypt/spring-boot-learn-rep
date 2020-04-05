package com.icypt.sboot.mapper;

import com.icypt.sboot.dto.UserDTO;
import com.icypt.sboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper  {
   void updateById(User user);

   void deleteById(Long userId);

   User findById(Long userId);

   void insert(User user);

   void batchInsert(@Param("userList") List<User> userList);

   List<User> findByIds(@Param("ids")Long[] ids);

   UserDTO getUserCompanyInfo(Long userId);

   UserDTO getUserBlogInfo(Long userId);
}