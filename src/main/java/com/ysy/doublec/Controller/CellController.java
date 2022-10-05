package com.ysy.doublec.Controller;

import com.alibaba.fastjson.JSON;
import com.ysy.doublec.Pojo.Cell;
import com.ysy.doublec.Pojo.CellPic;
import com.ysy.doublec.Service.CellService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cell")
public class CellController {
    @Autowired
    CellService cellService;

    @RequestMapping("/addCellPic")
    @ResponseBody
    public Map<String, Object> addCellPic(@Validated CellPic cellPic) throws IOException {
        String targetName = cellService.addCellPic(cellPic);
        HashMap result = new HashMap();
        result.put("targetName", targetName);
        result.put("src", "/uploads/" + targetName);
        return result;
    }

    @RequestMapping("/addCell")
    @ResponseBody
    public String addCell(String memberInfo) {
        Cell cell = JSON.parseObject(memberInfo, Cell.class);
        return cellService.addCell(cell);
    }

    @RequestMapping("/getCellCount")
    @ResponseBody
    public String getCellCount(String position) {
        return cellService.getCellCount(position);
    }

    @RequestMapping("/listCells")
    @ResponseBody
    public ArrayList<Cell> listCells(String start, String position) {
        return cellService.listCells(start, position);
    }

    @RequestMapping("/getCell")
    @ResponseBody
    public Cell getCell(String id) {
        Cell cell = cellService.getCell(id);
        return cell;
    }

    @RequestMapping("/cell_charge")
    @ResponseBody
    public void cell_charge(String ids) {
        String[] chargeIds = ids.split(",");
        cellService.cell_charge(chargeIds);
    }

    @RequestMapping("/cell_scrap")
    @ResponseBody
    public void cell_scrap(String ids) {
        String[] scrapIds = ids.split(",");
        cellService.cell_scrap(scrapIds);
    }

    @RequestMapping("/editCell")
    @ResponseBody
    public String editCell(String cellInfo) {
        if (cellInfo.equals("")) {
            return "非法操作！！";
        }
        Cell cell = JSON.parseObject(cellInfo, Cell.class);
        return cellService.editCell(cell);
    }

}
