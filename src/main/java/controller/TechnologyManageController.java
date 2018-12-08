package controller;

import bean.TechnologyManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TechnologyManageServiceImple;
import service.TechnologyPlanService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/technology")
public class TechnologyManageController {
    @Autowired
    TechnologyManageServiceImple service;

    @ResponseBody
    @RequestMapping("/list")
    public Map find(HttpServletRequest request){
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        List<TechnologyManage> manages =service.getTechnologyByPage(Integer.parseInt(page),Integer.parseInt(rows));
        //List<TechnologyManage> manages = service.getAllTechnology();
        Map map = new HashMap();
        map.put("rows",manages);
        map.put("total",manages.size());
        return map;
    }
    @ResponseBody
    @RequestMapping("/add_judge")
    public String add1(){
        return "{}";
    }

    @ResponseBody
    @RequestMapping("/edit_judge")
    public String edit_judge(){
        return "{}";
    }
    @RequestMapping("/find")
    public String list(){
        return "technology_list";
    }
    @RequestMapping("/add")
    public String add(){
        return "technology_add";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "technology_edit";
    }

    @ResponseBody
    @RequestMapping("/delete_judge")
    public String delete_judge(){

        return "{}";
    }
   /* get/005*/
   @ResponseBody
   @RequestMapping("/get_data")
   public List get_data() {
       List<TechnologyManage> technology = service.getAllTechnology();
       return technology;
   }
    @ResponseBody
    @RequestMapping("/get/{id1}")
    public TechnologyManage delete_judge(@PathVariable String id1,HttpServletRequest request){
       // String id1 = request.getParameter("id");
        TechnologyManage manage = service.selectByPrimaryKey(id1);
           /*Map map = new HashMap();
           map.put()*/
        return manage;
    }


    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map delete_batch(HttpServletRequest request){
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
    @RequestMapping(" /update_all")
    public Map update(@Valid TechnologyManage manage, BindingResult bindingResult){
        Map map = new HashMap<>();
        System.out.println(manage);

        if (validate(bindingResult, map))
        {
            return map;
        }
        //TechnologyManage select = service.selectByPrimaryKey(manage.getTechnologyId());

            int insert = service.updateByPrimaryKey(manage);
            map.put("status",200);

        return map;

    }

    private boolean validate(BindingResult bindingResult, Map map) {
        if (bindingResult.hasFieldErrors()) {

            FieldError username = bindingResult.getFieldError("technologyId");
            String field = username.getDefaultMessage();
            map.put("msg", field);
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(@Valid TechnologyManage manage, BindingResult bindingResult){
       Map map = new HashMap<>();
        if (validate(bindingResult, map)) {
            return map;
        }
        TechnologyManage select = service.selectByPrimaryKey(manage.getTechnologyId());
        if(select!=null){
            map.put("msg","the id has existed");

        }
        else {
            int insert = service.insert(manage);
            map.put("status",200);
        }
        return map;

    }
   /* /search_technology_by_technologyId?searchValue=001&page=1&rows=30*/
    @ResponseBody
    @RequestMapping("/search_technology_by_technologyId")
    public Map search_technology_by_technologyId(HttpServletRequest request){
        String value = request.getParameter("searchValue");
        TechnologyManage manage = service.selectByPrimaryKey(value);
        Map map = new HashMap();
        if(manage==null){
            map.put("total",0);
        }
        else {
            List rows = new ArrayList();
            rows.add(manage);
            map.put("rows",rows);
            map.put("total",1);
        }
 return map;
    }

   /* search_technology_by_technologyName?searchValue=*/
    @ResponseBody
    @RequestMapping("/search_technology_by_technologyName")
    public Map technology_by_technologyName(HttpServletRequest request){
        String value = request.getParameter("searchValue");
        List manage = service.selectByName(value);
        Map map = new HashMap();
        if(manage==null){
            map.put("total",0);
        }
        else {

            map.put("rows",manage);
            map.put("total",1);
        }
        return map;
    }


}
