package com.todo.system.backend.controller;

import com.todo.system.backend.config.AppBackendConfigProperties;
//import com.todo.system.backend.utils.BPwdEncoderUtil;
import com.todo.system.entity.bo.LoginUserBo;
import com.todo.system.entity.po.SysAdmin;
import com.todo.system.entity.vo.LoginUserVo;
import com.todo.system.util.web.UnifiedResponseObject;
import com.todo.system.util.web.UrlRegulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


//@Api(description = "用户相关api")
@RestController
@RequestMapping(UrlRegulation.RequestPrefix.REQ_NO_LOGIN + UrlRegulation.BizPrefix.USER)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppBackendConfigProperties appBackendConfigProperties;

    /**
     * 登录 login
     * @param request
     * @param response
     * @param loginUserBo
     * @param result
     * @return
     */
//    @ApiOperation(value = "用户登录", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userName", value = "用户名", required = true),
//            @ApiImplicitParam(name = "password", value = "密码", required = true)
//    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UnifiedResponseObject Login(HttpServletRequest request, HttpServletResponse response, @Valid LoginUserBo loginUserBo, BindingResult result) {
        if (result.hasErrors()) {
            logger.error("用户login接口参数验证 {}", result.getAllErrors());
            return new UnifiedResponseObject().failMsg("用户名或密码为空或不合法");
        }

        SysAdmin sysAdmin = getSysAdminByName(loginUserBo.getUsername());

        if (sysAdmin == null) {
            return new UnifiedResponseObject<String>().failMsg("用户名或密码不合法");
        }

//        if (!BPwdEncoderUtil.matches(loginUserBo.getPassword(), sysAdmin.getPassword().replace("{bcrypt}","")))
//            return new UnifiedResponseObject<String>().failMsg("密码不正确");

        if (!loginUserBo.getPassword().equals(sysAdmin.getPassword()))
            return new UnifiedResponseObject<String>().failMsg("密码不正确");

        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setUsername(loginUserBo.getUsername());
        return new UnifiedResponseObject<LoginUserVo>().successMsg(loginUserVo);
    }

    private SysAdmin getSysAdminByName(String userName) {
        MultiValueMap<String, String> map =  new LinkedMultiValueMap<String, String>();
        map.add("userName", userName);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestParam = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<SysAdmin> result_admin = restTemplate.exchange(appBackendConfigProperties.getGatewayHost()+"/admin/oauth/login", HttpMethod.POST, requestParam, SysAdmin.class);

        return result_admin.getBody();
    }
}
