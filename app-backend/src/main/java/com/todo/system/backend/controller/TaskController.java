package com.todo.system.backend.controller;

import com.todo.system.backend.config.AppBackendConfigProperties;
import com.todo.system.entity.bo.TaskInfoBo;
import com.todo.system.util.utils.PageVo;
import com.todo.system.util.web.UnifiedResponseObject;
import com.todo.system.util.web.UrlRegulation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping(UrlRegulation.RequestPrefix.REQ_NO_LOGIN + UrlRegulation.BizPrefix.TASK)
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppBackendConfigProperties appBackendConfigProperties;

    @PostMapping(value = "/addTask")
    @ApiOperation(value = "添加任务详情")
    public UnifiedResponseObject addTaskInfo(@Valid TaskInfoBo taskInfoBo, BindingResult result){
        if (result.hasErrors()) {
            logger.error("测试validate {}", result.getAllErrors());
            throw new ValidationException("Validate验证处理生效，请查看日志");
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TaskInfoBo> httpEntity = new HttpEntity<>(taskInfoBo, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(appBackendConfigProperties.getGatewayHost() + "/task/addTask", httpEntity, String.class);
        String resultBody = responseEntity.getBody();

        logger.info("app-backend端调用测试 {} ", resultBody);

        return new UnifiedResponseObject<Integer>().successMsg(Integer.valueOf(resultBody));
    }

    @GetMapping(value = "/getTask")
    @ApiOperation(value = "根据id查询单条任务详细信息")
    public UnifiedResponseObject getTaskInfo(String id){
        MultiValueMap<String, String> map =  new LinkedMultiValueMap<String, String>();
        map.add("id", id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestParam = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ParameterizedTypeReference<TaskInfoBo> typeRef = new ParameterizedTypeReference<TaskInfoBo>(){};

        ResponseEntity<TaskInfoBo> taskInfoBoInfoPageVo = restTemplate.exchange(appBackendConfigProperties.getGatewayHost()+"/task/getTask",HttpMethod.POST, requestParam,typeRef);

        return new UnifiedResponseObject<TaskInfoBo>().successMsg(taskInfoBoInfoPageVo.getBody());
    }

    @GetMapping(value = "/taskList")
    @ApiOperation(value = "根据部分字段和时间查询任务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", dataType = "String"),
            @ApiImplicitParam(name = "follow", value = "是否关注", dataType = "Integer"),
            @ApiImplicitParam(name = "instancy", value = "紧急程度", dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "任务状态", dataType = "Integer"),
            @ApiImplicitParam(name = "category", value = "任务类别", dataType = "String"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String")
    })
    public UnifiedResponseObject taskInfoList(@RequestParam(required = false)String title,
                                              @RequestParam(required = false)Integer follow,
                                              @RequestParam(required = false)Integer instancy,
                                              @RequestParam(required = false)Integer status,
                                              @RequestParam(required = false)String category,
                                              @RequestParam(required = false)String startTime,
                                              @RequestParam(required = false)String endTime,
                                              @RequestParam(value = "page", required = false, defaultValue = "1") Integer page ,
                                              @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize){
        MultiValueMap<String, String> map =  new LinkedMultiValueMap<String, String>();
        map.add("title", title);
        map.add("follow", follow.toString());
        map.add("instancy", instancy.toString());
        map.add("status", status.toString());
        map.add("category", category);
        map.add("startTime", startTime);
        map.add("endTime", endTime);
        map.add("page",page.toString());
        map.add("pageSize",pageSize.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestParam = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ParameterizedTypeReference<PageVo<TaskInfoBo>> typeRef = new ParameterizedTypeReference<PageVo<TaskInfoBo>>(){};
        ResponseEntity<PageVo<TaskInfoBo>> memberInfoBoInfoPageVo = restTemplate.exchange(appBackendConfigProperties.getGatewayHost()+"/task/taskList", HttpMethod.POST, requestParam,typeRef);
        return new UnifiedResponseObject<PageVo<TaskInfoBo>>().successMsg(memberInfoBoInfoPageVo.getBody());
    }

    @DeleteMapping(value = "/deleteTask")
    @ApiOperation(value = "删除任务", notes = "根据任务ID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "任务ID", dataType = "String", required = true)
    })
    public UnifiedResponseObject taskInfoList(String id){
        MultiValueMap<String, String> map =  new LinkedMultiValueMap<String, String>();
        map.add("id",id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestParam = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        String returnCode = restTemplate.exchange(appBackendConfigProperties.getGatewayHost()+"/task/deleteTask",HttpMethod.POST, requestParam,String.class).getBody();
        return new UnifiedResponseObject<String>().successMsg(returnCode);
    }
}
