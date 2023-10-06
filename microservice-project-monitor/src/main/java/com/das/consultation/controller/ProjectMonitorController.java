package com.das.consultation.controller;

import com.das.consultation.config.ParamConfig;
import com.das.consultation.entities.dto.*;
import com.das.consultation.entities.param.ProjectOppmParam;
import com.das.consultation.entities.vo.*;
import com.das.consultation.enums.PersonPositionEnum;
import com.das.consultation.enums.ProjectEnum;
import com.das.consultation.enums.ProjectProgressStatusEnum;
import com.das.consultation.service.*;
import com.das.consultation.util.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: LJS
 * @Date: 2023/3/3 13:06
 */
@RestController
@RequestMapping("/project")
public class ProjectMonitorController {

    private Logger logger = LoggerFactory.getLogger(ProjectMonitorController.class);

    @Resource
    private ProjectService projectService;

    @Resource
    private ProjectCostService projectCostService;

    @Resource
    private ProjectProgressRecordService projectProgressRecordService;

    @Resource
    private ProjectEventRecordService projectEventRecordService;

    @Resource
    private PersonService personService;

    @Resource
    private PersonMoveRecordService personMoveRecordService;

    @Autowired
    private ParamConfig paramConfig;

    /**
     * 医院经营数据列表
     * @return
     */
    @RequestMapping(value = "/overview", method = RequestMethod.POST)
    public ResponseEntity<String> projectOverview() {
        logger.info(">>>>>>>>>>{} start", "/project/overview");
        /* 局部变量 */
        List<ProjectOverviewVO> projectOverviewVOList = new ArrayList<>();
        List<ProjectPersonOverviewDTO> projectPersonOverviewDTOList;
        List<ProjectProgressOverviewDTO> projectProgressOverviewDTOList;
        Map<String, List<ProjectProgressVO>> projectProgressOverviewMap = new HashMap<>();
        List<ProjectPersonMoveOverviewDTO> projectPersonMoveOverviewDTOList;
        Map<String, List<PersonMoveVO>> projectPersonMoveOverviewMap = new HashMap<>();
        List<ProjectEventOverviewDTO> projectEventOverviewDTOList;
        Map<String, List<ProjectEventVO>> projectEventOverviewMap = new HashMap<>();
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM");

        try {
            /* 数据查询 */
            projectPersonOverviewDTOList = projectService.getProjectPersonOverviewList();
            projectProgressOverviewDTOList = projectProgressRecordService.getProjectProgressOverviewList();
            projectPersonMoveOverviewDTOList = personMoveRecordService.getProjectPersonMoveOverviewList();
            projectEventOverviewDTOList = projectEventRecordService.getProjectEventOverviewList(1);

            /* 数据组装-人员动向 */
            for(ProjectPersonMoveOverviewDTO projectPersonMoveOverviewDTO : projectPersonMoveOverviewDTOList) {
                String projectName = projectPersonMoveOverviewDTO.getProjectName();
                List<PersonMoveVO> tempPersonMoveVOList = projectPersonMoveOverviewMap.get(projectName);
                if (null == tempPersonMoveVOList || tempPersonMoveVOList.isEmpty()) {
                    tempPersonMoveVOList = new ArrayList<>();
                    projectPersonMoveOverviewMap.put(projectName, tempPersonMoveVOList);
                }
                PersonMoveVO personMoveVO = new PersonMoveVO();
                personMoveVO.setPersonName(projectPersonMoveOverviewDTO.getPersonName());
                personMoveVO.setSupportProjectName(projectPersonMoveOverviewDTO.getSupportProjectName());
                personMoveVO.setStartDate(dateFormat1.format(projectPersonMoveOverviewDTO.getStartDate()));
                if (null != projectPersonMoveOverviewDTO.getEndDate()) {
                    personMoveVO.setEndDate(dateFormat1.format(projectPersonMoveOverviewDTO.getEndDate()));
                }
                personMoveVO.setSupportInfo(projectPersonMoveOverviewDTO.getSupportInfo());
                tempPersonMoveVOList.add(personMoveVO);
            }

            /* 数据组装-项目进度 */
            for(ProjectProgressOverviewDTO projectProgressOverviewDTO : projectProgressOverviewDTOList) {
                String projectName = projectProgressOverviewDTO.getProjectName();
                List<ProjectProgressVO> tempProjectProgressVOList = projectProgressOverviewMap.get(projectName);
                if (null == tempProjectProgressVOList || tempProjectProgressVOList.isEmpty()) {
                    tempProjectProgressVOList = new ArrayList<>();
                    projectProgressOverviewMap.put(projectName, tempProjectProgressVOList);
                }
                ProjectProgressVO projectProgressVO = new ProjectProgressVO();
                projectProgressVO.setNodeName(projectProgressOverviewDTO.getNodeName());
                projectProgressVO.setPlanDate(dateFormat2.format(projectProgressOverviewDTO.getPlanDate()));
                projectProgressVO.setStatus(projectProgressOverviewDTO.getStatus());
                projectProgressVO.setInfo(projectProgressOverviewDTO.getInfo());
                tempProjectProgressVOList.add(projectProgressVO);
            }

            /* 数据组装-重大事件 */
            for(ProjectEventOverviewDTO projectEventOverviewDTO : projectEventOverviewDTOList) {
                String projectName = projectEventOverviewDTO.getProjectName();
                List<ProjectEventVO> tempProjectEventVOList = projectEventOverviewMap.get(projectName);
                if (null == tempProjectEventVOList || tempProjectEventVOList.isEmpty()) {
                    tempProjectEventVOList = new ArrayList<>();
                    projectEventOverviewMap.put(projectName, tempProjectEventVOList);
                }
                ProjectEventVO projectEventVO = new ProjectEventVO();
                projectEventVO.setEventName(projectEventOverviewDTO.getEventName());
                projectEventVO.setEventDate(dateFormat2.format(projectEventOverviewDTO.getEventDate()));
                tempProjectEventVOList.add(projectEventVO);
            }

            /* 数据组装-项目人员数 */
            if (null == projectPersonOverviewDTOList) {

            }
            for (ProjectPersonOverviewDTO projectPersonOverviewDTO : projectPersonOverviewDTOList) {
                String projectName = projectPersonOverviewDTO.getProjectName();
                ProjectOverviewVO projectOverviewVO = new ProjectOverviewVO();
                projectOverviewVO.setName(ProjectEnum.getProjectShortName(projectPersonOverviewDTO.getProjectName()));
                projectOverviewVO.setPersonNumber(projectPersonOverviewDTO.getPersonNumber());
                projectOverviewVO.setProgressList(projectProgressOverviewMap.get(projectName));
                projectOverviewVO.setMoveList(projectPersonMoveOverviewMap.get(projectName));
                projectOverviewVO.setEventList(projectEventOverviewMap.get(projectName));
                projectOverviewVOList.add(projectOverviewVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResultUtils.fail("失败信息：" + e.getMessage()));
        }

        /* 服务返回 */
        logger.info("<<<<<<<<<<{} end", "/project/overview");
        return ResponseEntity.ok(ResultUtils.success(projectOverviewVOList));
    }

    /**
     * 项目总览明细
     * @return
     */
    @RequestMapping(value = "/overview/detail", method = RequestMethod.POST)
    public ResponseEntity<String> projectOverviewDetail() {
        logger.info(">>>>>>>>>>{} start", "/overview/detail");
        /* 局部变量 */
        List<ProjectOverviewDetailVO> projectOverviewDetailVOList = new ArrayList<>();
        List<ProjectOverviewDetailDTO> projectOverviewDTOList;
        List<ProjectEventOverviewDTO> projectEventOverviewDTOList;
        Map<String, List<ProjectEventVO>> projectEventOverviewMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            /* 数据查询 */
            projectOverviewDTOList = projectService.getProjectOverviewDetailList();
            projectEventOverviewDTOList = projectEventRecordService.getProjectEventOverviewList(2);

            /* 数据组装-客户投诉与嘉奖 */
            for(ProjectEventOverviewDTO projectEventOverviewDTO : projectEventOverviewDTOList) {
                String projectName = projectEventOverviewDTO.getProjectName();
                List<ProjectEventVO> tempProjectEventVOList = projectEventOverviewMap.get(projectName);
                if (null == tempProjectEventVOList || tempProjectEventVOList.isEmpty()) {
                    tempProjectEventVOList = new ArrayList<>();
                    projectEventOverviewMap.put(projectName, tempProjectEventVOList);
                }
                ProjectEventVO projectEventVO = new ProjectEventVO();
                projectEventVO.setEventName(projectEventOverviewDTO.getEventName());
                projectEventVO.setEventDate(dateFormat.format(projectEventOverviewDTO.getEventDate()));
                tempProjectEventVOList.add(projectEventVO);
            }
            /* 数据组装 */
            if (null == projectOverviewDTOList) {

            }
            for (ProjectOverviewDetailDTO projectOverviewDetailDTO : projectOverviewDTOList) {
                ProjectOverviewDetailVO projectOverviewDetailVO = new ProjectOverviewDetailVO();
                projectOverviewDetailVO.setName(projectOverviewDetailDTO.getProjectName());
                projectOverviewDetailVO.setPlanCost(projectOverviewDetailDTO.getPlanCost());
                projectOverviewDetailVO.setOccurredCost(projectOverviewDetailDTO.getOccurredCost());
                projectOverviewDetailVO.setEvent(projectEventOverviewMap.get(projectOverviewDetailDTO.getProjectName()));
                projectOverviewDetailVOList.add(projectOverviewDetailVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResultUtils.fail("失败信息：" + e.getMessage()));
        }

        /* 服务返回 */
        logger.info("<<<<<<<<<<{} end", "/overview/detail");
        return ResponseEntity.ok(ResultUtils.success(projectOverviewDetailVOList));
    }

    /**
     * 项目OPPM
     * @return
     */
    @RequestMapping(value = "/oppm", method = RequestMethod.POST)
    public ResponseEntity<String> projectOppm(@RequestBody ProjectOppmParam projectOppmParam) {
        logger.info(">>>>>>>>>>{} start", "/oppm");
        /* 局部变量 */
        ProjectOppmVO projectOppmVO = new ProjectOppmVO();
        String oppmImageUrl;
        String oppmImageName;
        try {
            /* 数据校验 */
            if (StringUtils.isEmpty(projectOppmParam.getProjectName())) {
                return ResponseEntity.ok(ResultUtils.fail("请输入项目名称"));
            }
            // 此处前端传回的为项目简称
            oppmImageName = ProjectEnum.getProjectCodeByShortName(projectOppmParam.getProjectName());
            if (StringUtils.isEmpty(oppmImageName)) {
                return ResponseEntity.ok(ResultUtils.fail("该项目暂未上传至系统"));
            }
            /* 图像获取 */

            /* 数据组装 */
            oppmImageUrl = paramConfig.getOppmImageUrl() + oppmImageName + ".png";
            projectOppmVO.setOppmImageUrl(oppmImageUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResultUtils.fail("失败信息：" + e.getMessage()));
        }

        /* 服务返回 */
        logger.info("<<<<<<<<<<{} end", "/oppm");
        return ResponseEntity.ok(ResultUtils.success(projectOppmVO));
    }

    /**
     * Excel上传
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/excel/upload", method = RequestMethod.POST)
    public ResponseEntity<String> excelUpload(@RequestParam("file") MultipartFile file) throws Exception {
        logger.info(">>>>>>>>>>{} start", "/hospital/operation/data/list");
        /* 局部变量 */
        // 项目编号
        // 项目对象
        ProjectDTO projectDTO = new ProjectDTO();
        // 项目费用对象
        ProjectCostDTO projectCostDTO = new ProjectCostDTO();
        // 项目进度集合
        List<ProjectProgressRecordDTO> projectProgressRecordDTOList = new ArrayList<>();
        // 项目重大事项、客户投诉与嘉奖集合
        List<ProjectEventRecordDTO> projectEventRecordDTOList = new ArrayList<>();
        // 人员集合
        List<PersonDTO> personDTOList = new ArrayList<>();
        // 人员动向集合
        List<PersonMoveRecordDTO> personMoveRecordDTOList = new ArrayList<>();

        try {
            /* Excel上传 */
            String parentFilePath = "D:" + File.separator + "microservice-project-monitor" + File.separator + "file" + File.separator;
            String newZipName = "项目信息填报.xlsx";
            File excelFile = new File(parentFilePath + File.separator + newZipName);
            file.transferTo(excelFile);

            /* Excel解析，数据集合组装 */
            parseExcel(excelFile, projectDTO, projectCostDTO, projectProgressRecordDTOList, projectEventRecordDTOList, personDTOList ,personMoveRecordDTOList);

            /* 数据存储及更新 */
            // 项目是否已存在
            if (StringUtils.isEmpty(projectDTO.getProjectCode())) {
                return ResponseEntity.ok(ResultUtils.fail("请填写项目名称"));
            }
            ProjectDTO dbProjectDTO = projectService.selectOne(projectDTO.getProjectCode());
            if (null == dbProjectDTO) {
                if (!StringUtils.isEmpty(projectDTO.getProjectCode())) {
                    projectService.insert(projectDTO);
                }
                if (!StringUtils.isEmpty(projectCostDTO.getProjectCode())) {
                    projectCostService.insert(projectCostDTO);
                }
                if (!projectProgressRecordDTOList.isEmpty()) {
                    projectProgressRecordService.insertList(projectProgressRecordDTOList);
                }
                if (!projectEventRecordDTOList.isEmpty()) {
                    projectEventRecordService.insertList(projectEventRecordDTOList);
                }
                if (!personDTOList.isEmpty()) {
                    personService.insertList(personDTOList);
                }
                if (!personMoveRecordDTOList.isEmpty()) {
                    personMoveRecordService.insertList(personMoveRecordDTOList);
                }
            } else {
                String projectCode = projectDTO.getProjectCode();
                projectService.delete(projectCode);
                projectCostService.delete(projectCode);
                projectProgressRecordService.delete(projectCode);
                projectEventRecordService.delete(projectCode);
                personService.delete(projectCode);
                personMoveRecordService.delete(projectCode);

                if (!StringUtils.isEmpty(projectDTO.getProjectCode())) {
                    projectService.insert(projectDTO);
                }
                if (!StringUtils.isEmpty(projectCostDTO.getProjectCode())) {
                    projectCostService.insert(projectCostDTO);
                }
                if (!projectProgressRecordDTOList.isEmpty()) {
                    projectProgressRecordService.insertList(projectProgressRecordDTOList);
                }
                if (!projectEventRecordDTOList.isEmpty()) {
                    projectEventRecordService.insertList(projectEventRecordDTOList);
                }
                if (!personDTOList.isEmpty()) {
                    personService.insertList(personDTOList);
                }
                if (!personMoveRecordDTOList.isEmpty()) {
                    personMoveRecordService.insertList(personMoveRecordDTOList);
                }

            }

//            /* 参数校验 */
//            startDate = dateRangeQueryParam.getStartDate();
//            endDate = dateRangeQueryParam.getEndDate();
//            if (null == startDate) {
//                return ResponseEntity.ok(ResultUtils.fail("请输入开始日期"));
//            }
//            if (null == endDate) {
//                return ResponseEntity.ok(ResultUtils.fail("请输入结束日期"));
//            }
//
//            /* 数据统计 */
//            hospitalOperationDataDTOList = hospitalService.selectOperationDataList(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResultUtils.fail("上传异常 " + e.getMessage()));
        }

        /* 服务返回 */
        logger.info("<<<<<<<<<<{} end", "/hospital/operation/data/list");
        return ResponseEntity.ok(ResultUtils.success("上传成功"));
    }

    public int parseExcel(File file, ProjectDTO projectDTO, ProjectCostDTO projectCostDTO, List<ProjectProgressRecordDTO> projectProgressRecordDTOList, List<ProjectEventRecordDTO> projectEventRecordDTOList, List<PersonDTO> personDTOList, List<PersonMoveRecordDTO> personMoveRecordDTOList) throws Exception {
        /* 局部变量 */
        String projectCode;
        String projectName;
        String value = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (!file.exists()) {
            logger.error("excel文件不存在");
            return 0;
        }
        //获取文件输入流
        InputStream is = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(is);
        //根据名称获取sheet
        Sheet sheet = workbook.getSheetAt(0);

        //获取
        int lastRowNum = sheet.getLastRowNum();

        // 项目
        value = sheet.getRow(2).getCell(0).getStringCellValue();
        projectName = value;
        projectCode = ProjectEnum.getProjectCode(projectName);
        projectDTO.setProjectCode(projectCode);
        projectDTO.setProjectName(projectName);
        projectDTO.setSort(ProjectEnum.getProjectSort(projectName));
        projectDTO.setVersion(1);
        projectDTO.setState(1);
        projectDTO.setUpdateTime(new Date());

        // 项目成本
        double value1 = sheet.getRow(2).getCell(1).getNumericCellValue();
        double value2 = sheet.getRow(2).getCell(2).getNumericCellValue();
        projectCostDTO.setPlanCost(value1);
        projectCostDTO.setOccurredCost(value2);
        projectCostDTO.setProjectCode(projectCode);
        projectCostDTO.setVersion(1);
        projectCostDTO.setState(1);
        projectCostDTO.setUpdateTime(new Date());

        // 项目进度
        for (int i = 2; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            // 本行项目进度数据是否存在
            ProjectProgressRecordDTO projectProgressRecordDTO = null;
            Cell cell3 = row.getCell(3);
            if (null == cell3) {
                break;
            }
            value = cell3.getStringCellValue();
            if (StringUtils.isEmpty(value)) {
                break;
            }
            projectProgressRecordDTO = new ProjectProgressRecordDTO();
            projectProgressRecordDTO.setNodeName(value);
            Cell cell4 = row.getCell(4);
            value = cell4.getStringCellValue();
            projectProgressRecordDTO.setPlanDate(dateFormat.parse(value+"-01"));
            Cell cell5 = row.getCell(5);
            value = cell5.getStringCellValue();
            projectProgressRecordDTO.setStatus(ProjectProgressStatusEnum.getStatusCode(value));
            Cell cell6 = row.getCell(6);
            value = cell6.getStringCellValue();
            projectProgressRecordDTO.setInfo(value);
            projectProgressRecordDTO.setProjectCode(projectCode);
            projectProgressRecordDTO.setState(1);
            projectProgressRecordDTO.setUpdateTime(new Date());
            projectProgressRecordDTOList.add(projectProgressRecordDTO);
        }

        // 重大事项
        for (int i = 2; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            // 本行项目进度数据是否存在
            ProjectEventRecordDTO projectEventRecordDTO = null;
            Cell cell7 = row.getCell(7);
            if (null == cell7) {
                break;
            }
            value = cell7.getStringCellValue();
            if (StringUtils.isEmpty(value)) {
                break;
            }
            projectEventRecordDTO = new ProjectEventRecordDTO();
            projectEventRecordDTO.setEventName(value);
            Cell cell8 = row.getCell(8);
            projectEventRecordDTO.setEventDate(getCellDateValue(cell8));
            projectEventRecordDTO.setType(1);
            projectEventRecordDTO.setProjectCode(projectCode);
            projectEventRecordDTO.setState(1);
            projectEventRecordDTO.setUpdateTime(new Date());
            projectEventRecordDTOList.add(projectEventRecordDTO);
        }

        // 客户投诉与嘉奖
        for (int i = 2; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            // 本行项目进度数据是否存在
            ProjectEventRecordDTO projectEventRecordDTO = null;
            Cell cell9 = row.getCell(9);
            if (null == cell9) {
                break;
            }
            value = cell9.getStringCellValue();
            if (StringUtils.isEmpty(value)) {
                break;
            }
            projectEventRecordDTO = new ProjectEventRecordDTO();
            projectEventRecordDTO.setEventName(value);
            Cell cell10 = row.getCell(10);
            projectEventRecordDTO.setEventDate(getCellDateValue(cell10));
            projectEventRecordDTO.setType(2);
            projectEventRecordDTO.setProjectCode(projectCode);
            projectEventRecordDTO.setState(1);
            projectEventRecordDTO.setUpdateTime(new Date());
            projectEventRecordDTOList.add(projectEventRecordDTO);
        }

        // 项目现有人员
        for (int i = 2; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            // 本行项目进度数据是否存在
            PersonDTO personDTO = null;
            Cell cell11 = row.getCell(11);
            if (null == cell11) {
                break;
            }
            value = cell11.getStringCellValue();
            if (StringUtils.isEmpty(value)) {
                break;
            }
            personDTO = new PersonDTO();
            personDTO.setPersonCode(value);
            Cell cell12 = row.getCell(12);
            personDTO.setPersonName(cell12.getStringCellValue());
            Cell cell13 = row.getCell(13);
            personDTO.setPosition(PersonPositionEnum.getPositionCode(cell13.getStringCellValue()));
            Cell cell14 = row.getCell(14);
            personDTO.setBaseProjectCode(ProjectEnum.getProjectCode(cell14.getStringCellValue()));
            personDTO.setCurrentProjectCode(projectCode);
            personDTO.setVersion(1);
            personDTO.setState(1);
            personDTO.setUpdateTime(new Date());
            personDTOList.add(personDTO);
        }

        // 项目人员动向
        for (int i = 2; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            // 本行项目进度数据是否存在
            PersonMoveRecordDTO personMoveRecordDTO = null;
            Cell cell115 = row.getCell(15);
            if (null == cell115) {
                break;
            }
            value = cell115.getStringCellValue();
            if (StringUtils.isEmpty(value)) {
                break;
            }
            personMoveRecordDTO = new PersonMoveRecordDTO();
            personMoveRecordDTO.setPersonCode(value);
            Cell cell16 = row.getCell(16);
            personMoveRecordDTO.setPersonName(cell16.getStringCellValue());
            Cell cell17 = row.getCell(17);
            personMoveRecordDTO.setPosition(PersonPositionEnum.getPositionCode(cell17.getStringCellValue()));
            personMoveRecordDTO.setBaseProjectCode(projectCode);
            personMoveRecordDTO.setBaseProjectName(projectName);
            Cell cell18 = row.getCell(18);
            personMoveRecordDTO.setSupportProjectCode(ProjectEnum.getProjectCode(cell18.getStringCellValue()));
            personMoveRecordDTO.setSupportProjectName(cell18.getStringCellValue());
            Cell cell19 = row.getCell(19);
            personMoveRecordDTO.setStartDate(getCellDateValue(cell19));
            Cell cell20 = row.getCell(20);
            personMoveRecordDTO.setEndDate(getCellDateValue(cell20));
            Cell cell21 = row.getCell(21);
            personMoveRecordDTO.setSupportInfo(cell21.getStringCellValue());
            personMoveRecordDTO.setState(1);
            personMoveRecordDTO.setUpdateTime(new Date());
            personMoveRecordDTOList.add(personMoveRecordDTO);
        }

        /* 输入流关闭 */
        is.close();
        return 1;
    }

    public static Date getCellDateValue(Cell cell) throws ParseException{
        if (null == cell) {
            return null;
        }
        if (CellType.NUMERIC == cell.getCellTypeEnum()) {
            return cell.getDateCellValue();
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String value = cell.getStringCellValue();
            if (StringUtils.isEmpty(value)) {
                return null;
            }
            if (value.length() < 8) {
                value = value + "-01";
            }
            return dateFormat.parse(value);
        }
    }

//    public static String getCellValue(Cell cell) {
//        String cellValue = "";
//        if (cell == null) {
//            return cellValue;
//        }
//        //把数字当成String来读，避免出现1读成1.0的情况
//        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//            cell.setCellType(Cell.CELL_TYPE_STRING);
//        }
//        //判断数据的类型
//        switch (cell.getCellType()) {
//            case Cell.CELL_TYPE_NUMERIC: //数字
//                cellValue = String.valueOf(cell.getNumericCellValue());
//                break;
//            case Cell.CELL_TYPE_STRING: //字符串
//                cellValue = String.valueOf(cell.getStringCellValue());
//                break;
//            case Cell.CELL_TYPE_BOOLEAN: //Boolean
//                cellValue = String.valueOf(cell.getBooleanCellValue());
//                break;
//            case Cell.CELL_TYPE_FORMULA: //公式
//                cellValue = String.valueOf(cell.getCellFormula());
//                break;
//            case Cell.CELL_TYPE_BLANK: //空值
//                cellValue = "";
//                break;
//            case Cell.CELL_TYPE_ERROR: //故障
//                cellValue = "非法字符";
//                break;
//            default:
//                cellValue = "未知类型";
//                break;
//        }
//        return cellValue;
//    }

}
