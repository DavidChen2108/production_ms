package controller;

import bean.TechnologyManage;
import bean.TechnologyRequirement;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TechnologyManageServiceImple;
import service.TechnologyRequirementService;
import service.TechnologyRequirementServiceImple;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementServiceImple service;
    @Autowired
    TechnologyManageServiceImple manageService;
    @RequestMapping("/find")
    public String find(){
        return "technologyRequirement_list";
    }

    /*list?page=1&rows=30*/
    @ResponseBody
    @RequestMapping("/list")
    public Map list(HttpServletRequest request){
        Map map = new HashMap();
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        PageInfo<TechnologyRequirement> info = service.selectDocByPage1(Integer.parseInt(page), Integer.parseInt(rows));
        /*map.put("rows",list);
        map.put("total",list.size());*/
        List<TechnologyRequirement> list = info.getList();
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
        return "technologyRequirement_add";
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List get_data(){
        List<TechnologyManage> technology = manageService.getAllTechnology();
        return technology;
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert( TechnologyRequirement manage){
        Map map = new HashMap<>();
        /*if (validate(bindingResult, map)) {
            return map;
        }*/
        System.out.println(manage);
        TechnologyRequirement key = service.selectByPrimaryKey(manage.getTechnologyRequirementId());

        if(key!=null){
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
        return "technologyRequirement_edit";
    }

    @ResponseBody
    @RequestMapping(" /update_all")
    public Map update(TechnologyRequirement manage){
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

/*/search_technologyRequirement_by_technologyRequirementId?searchValue=1223&page=1&rows=30*/
    @ResponseBody
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    public Map search_technology_by_technologyId(HttpServletRequest request){
        String value = request.getParameter("searchValue");
        TechnologyRequirement requirement = service.selectByPrimaryKey(value);
        List rows = new ArrayList();
        Map map = new HashMap();
        if(requirement==null){
            map.put("total",0);
            map.put("rows",rows);
        }
        else {

            rows.add(requirement);
            map.put("rows",rows);
            map.put("total",1);
        }
        return map;
    }

   /*
    @RequestMapping("/find")
    public String list(){
        return "technologyRequirement_list";
    }



    @ResponseBody
    @RequestMapping("/delete_judge")
    public String delete_judge(){

        return "{}";
    }*/
}
