package com.das.consultation.mapper;

import com.das.consultation.entities.dto.PersonMoveRecordDTO;
import com.das.consultation.entities.dto.ProjectPersonMoveOverviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:45
 */
@Mapper
public interface PersonMoveRecordMapper {

    int insertList(@Param("personMoveRecordDTOList")List<PersonMoveRecordDTO> personMoveRecordDTOList);

    int delete(String projectCode);

    int delete(@Param("personMoveRecordDTOList") List<PersonMoveRecordDTO> personMoveRecordDTOList);

    List<ProjectPersonMoveOverviewDTO> getProjectPersonMoveOverviewList();

}
