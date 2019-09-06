package com.seven.roast.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.roast.entity.Roast;
import com.seven.roast.service.RoastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/6 5:51 PM
 * email  ：sevenryuu77@gmail.com
 */
@RestController
@RequestMapping("/roast")
public class RoastController {

    @Autowired
    private RoastService roastService;

    @RequestMapping(method = RequestMethod.GET)
    public ResultResponse findAll(){
        return new ResultResponse(ResultCode.SUCCESS, roastService.findAll());
    }

    @RequestMapping(value = "/{roastId}", method = RequestMethod.GET)
    public ResultResponse findById(@PathVariable String roastId){
        return new ResultResponse(ResultCode.SUCCESS, roastService.findById(roastId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResultResponse save(@RequestBody Roast roast){
        roastService.save(roast);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/{roastId}", method = RequestMethod.PUT)
    public ResultResponse update(@PathVariable String roastId, @RequestBody Roast roast){
        roast.set_id(roastId);
        roastService.update(roast);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/{roastId}", method = RequestMethod.DELETE)
    public ResultResponse deleteById(@PathVariable String roastId){
        roastService.deleteById(roastId);
        return new ResultResponse(ResultCode.SUCCESS);
    }
}
