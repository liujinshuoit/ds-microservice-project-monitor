package com.das.consultation.mapper;

import com.das.consultation.entities.dto.PersonDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:45
 */
@Mapper
public interface PersonMapper {

    int insertList(@Param("personDTOList") List<PersonDTO> personDTOList);

    int delete(String projectCode);

    int update(PersonDTO personDTO);

}
