package fun.maxs.wheel.controller;

import fun.maxs.wheel.entity.param.demo.ResultDemoParam;
import fun.maxs.wheel.entity.vo.demo.DemoListVO;
import fun.maxs.wheel.exception.BusinessException;
import fun.maxs.wheel.response.Response;
import fun.maxs.wheel.response.type.ActiveBusinessType;
import fun.maxs.wheel.response.type.BusinessType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    /**
     * 查看demo列表
     */
    @GetMapping("/list")
    public Response<List<DemoListVO>> list(){
        List<DemoListVO> voList = new ArrayList<>();
        voList.add(new DemoListVO("张三", 19));
        voList.add(new DemoListVO("李四", 27));
        return Response.success(voList);
    }

    /**
     * 返回信息
     */
    @PostMapping("/resultDemo")
    public Response<Map> resultDemo(@RequestBody ResultDemoParam request){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("email", "55156snufa@163.com");

        switch (request.getErrorType()){
            case 1:
                return Response.success();
            case 2:
                return Response.error(ActiveBusinessType.ACTIVE_EXPIRED);
            case 3:
                return Response.success(map);
            case 4:
                Assert.notNull(null, "");
                return Response.success();
            case 5:
                throw new BusinessException(ActiveBusinessType.ACTIVE_EXPIRED, new NullPointerException());
            case 6:
                throw new BusinessException(ActiveBusinessType.ACTIVE_EXPIRED, new NullPointerException(), map, null);
            case 7:
                throw new NullPointerException();
            default:
                throw new BusinessException(ActiveBusinessType.ACTIVE_TYPE_NOT_EXISTS);
        }
    }
}
