package controller;

import bean.TechnologyManage;
import bean.TechnologyPlan;
import bean.TechnologyRequirement;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TechnologyManageServiceImple;
import service.TechnologyPlanService;
import service.TechnologyPlanServiceImple;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanContoller {
    @Autowired
    TechnologyPlanServiceImple service;
    @Autowired
    TechnologyManageServiceImple manageService;

   /* @RequestMapping("/insert")
    public Map <String, Object>insert(TechnologyPlan technologyPlan){
        Map<String, Object> map = new HashMap<>();
        if(technologyPlan==null){
            map.put("msg","the information can't be null");
        }
        else {
            service.insert(technologyPlan);
            map.put("status",200);
        }
        return map;
    }*/
    @ResponseBody
    @RequestMapping("/list")
    public Map find(HttpServletRequest request){
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        PageInfo<TechnologyPlan> info = service.selectDocByPage1(Integer.parseInt(page), Integer.parseInt(rows));
        //List<TechnologyManage> manages = service.getAllTechnology();
        List<TechnologyPlan> list = info.getList();
        Map map = new HashMap();
        map.put("rows",list);
        map.put("total",list.size());
        return map;
    }
    @RequestMapping("/find")
    public String find(){
        return "technologyPlan_list";
    }

    @ResponseBody
    @RequestMapping("/add_judge")
    public String add1(){
        return "{}";
    }

    @RequestMapping("/add")
    public String add(){
        return "technologyPlan_add";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert( TechnologyPlan manage){
        Map map = new HashMap<>();
        /*if (validate(bindingResult, map)) {
            return map;
        }*/
        System.out.println(manage);
        TechnologyPlan plan = service.selectByPrimaryKey(manage.getTechnologyPlanId());


        if(plan!=null){
            map.put("msg","the id has existed");

        }
        else {
            int insert = service.insert(manage);
            map.put("status",200);
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/edit_judge")
    public String edit_judge(){
        return "{}";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "technologyPlan_edit";
    }

    @ResponseBody
    @RequestMapping(" /update_all")
    public Map update(TechnologyPlan manage){
        Map map = new HashMap<>();
        System.out.println(manage);

        int insert = service.updateByPrimaryKey(manage);
        map.put("status",200);

        return map;

    }

    @ResponseBody
    @RequestMapping("/delete_judge")
    public String delete_judge(){

        return "{}";
    }

    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map delete_batch(HttpServletRequest request){
        return deleteById(request);
    }

    private Map deleteById(HttpServletRequest request) {
        String ids = request.getParameter("ids");
        int i = service.deleteByPrimaryKey(ids);
        Map map = new HashMap();
        if(i!=0){
            map.put("status",200);
            map.put("msg","OK");
        }
        else {
            map.put("msg","删除失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    public Map search_technologyPlan_by_technologyPlanId(HttpServletRequest request){
        String value = request.getParameter("searchValue");
        TechnologyPlan plan = service.selectByPrimaryKey(value);
        List rows = new ArrayList();
        Map map = new HashMap();
        if(plan==null){
            map.put("total",0);
            map.put("rows",rows);
        }
        else {

            rows.add(plan);
            map.put("rows",rows);
            map.put("total",1);
        }
        return map;
    }






    @ResponseBody
    @RequestMapping("/search_technologyPlan_by_technologyName")
    public Map search_technologyPlan_by_technologyName(HttpServletRequest request){
        String value = request.getParameter("searchValue");
        List plan = service.selectByTechnologyName(value);
       /* List rows = new ArrayList();*/
        Map map = new HashMap();
        if(plan==null){
            map.put("total",0);
            map.put("rows",plan);
        }
        else {

            /*rows.add(plan);*/
            map.put("rows",plan);
            map.put("total",1);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List get_data() {
        List<TechnologyPlan> plan = service.getAllTechnologyPlan();
        return plan;
    }

   /* /get/001*/
    @ResponseBody
    @RequestMapping("/get/{id1}")
    public TechnologyPlan delete_judge(@PathVariable String id1, HttpServletRequest request){
        // String id1 = request.getParameter("id");
        TechnologyPlan manage = service.selectByPrimaryKey(id1);
           /*Map map = new HashMap();
           map.put()*/
        return manage;
    }




}
