package controller;


import bean.Process;
import bean.TechnologyPlan;
import bean.TechnologyRequirement;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProcessService;
import service.ProcessServiceImple;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    ProcessServiceImple service;

    @RequestMapping("/find")
    public String find(){
        return "process_list";
    }

    /*list?page=1&rows=30*/
    @ResponseBody
    @RequestMapping("/list")
    public Map list(HttpServletRequest request){
        Map map = new HashMap();
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        PageInfo<Process> info = service.selectDocByPage1(Integer.parseInt(page), Integer.parseInt(rows));
        /*map.put("rows",list);
        map.put("total",list.size());*/
        List<Process> list = info.getList();
        map.put("rows",list);
        map.put("total",list.size());
        return map;

    }

    @ResponseBody
    @RequestMapping("/add_judge")
    public String add1(){
        return "{}";
    }

    @RequestMapping("/add")
    public String add(){
        return "process_add";
    }


    @ResponseBody
    @RequestMapping("insert")
    public Map insert( Process manage){
        Map map = new HashMap<>();
        /*if (validate(bindingResult, map)) {
            return map;
        }*/
        System.out.println(manage);
        Process process = service.selectByPrimaryKey(manage.getProcessId());

        if(process!=null){
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
        return "process_edit";
    }

    @ResponseBody
    @RequestMapping(" /update_all")
    public Map update(Process manage){
        Map map = new HashMap<>();
        System.out.println(manage);

        /*if (validate(bindingResult, map))
        {
            return map;
        }*/
        //TechnologyManage select = service.selectByPrimaryKey(manage.getTechnologyId());

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
    @RequestMapping("/search_process_by_processId")
    public Map search_process_by_processId(HttpServletRequest request){
        String value = request.getParameter("searchValue");
        Process process = service.selectByPrimaryKey(value);
        List rows = new ArrayList();
        Map map = new HashMap();
        if(process==null){
            map.put("total",0);
            map.put("rows",rows);
        }
        else {

            rows.add(process);
            map.put("rows",rows);
            map.put("total",1);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("/search_process_by_technologyPlanId")
    public Map technology_by_technologyName(HttpServletRequest request){
        String value = request.getParameter("searchValue");
        List<Process> manage = service.technologyPlanId(value);
        Map map = new HashMap();
        for(Process process : manage){
            System.out.println(process);
        }
        if(manage==null){
            map.put("total",0);
        }
        else {

            map.put("rows",manage);
            map.put("total",1);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List get_data() {
        List<Process> processes = service.selectAllProcess();
        return processes;
    }

    @ResponseBody
    @RequestMapping("/get/{id1}")
    public Process delete_judge(@PathVariable String id1, HttpServletRequest request){
        // String id1 = request.getParameter("id");
        Process process = service.selectByPrimaryKey(id1);
           /*Map map = new HashMap();
           map.put()*/
        return process;
    }


}
