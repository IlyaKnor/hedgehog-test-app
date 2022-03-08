package com.knor.profileapp.mapper;

import com.knor.profileapp.model.Profile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProfileMapper {
    @Select("select id, name, surname from profile where id = #{id}")
    Profile select(@Param("id") long id);

    @Select("select id, name, surname from profile where lower(name) like #{segment}")
    List<Profile> selectByNameSegment(@Param("segment") String segment);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("Insert into profile(name, surname) values (#{name}, #{surname})")
    int insert(Profile profile);

    @Delete("delete from profile where id = #{id}")
    boolean delete(@Param("id") long id);
}
