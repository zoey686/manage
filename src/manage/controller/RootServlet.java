package manage.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.entity.Action;
import manage.entity.Article;
import manage.entity.Club;
import manage.service.RootService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/RootServlet")
public class RootServlet extends BaseServlet {
	
	/**
	 * 添加club
	 * 参数:Club.class
	 * @param request
	 * @param response
	 */
	public void addClub(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		Club club = (Club)getBean(map, "Club");
		new RootService().addClub(club);
		//返回前端
		JSONObject json = new JSONObject();
		json.put("flag", "true");
		write(response, json.toString());
	}
	
	/**
	 * 显示全部社团的所有信息
	 * @param request
	 * @param response
	 */
	public void showClubs(HttpServletRequest request, HttpServletResponse response) {
		List<Club> list = new RootService().showClubs();
		JSONArray json = new JSONArray();
		
		//多少个社团
		JSONObject jsonObjectLen = new JSONObject();
		jsonObjectLen.put("size", list.size());
		json.add(jsonObjectLen);
		
		//将list中的社团 添加到 JSONArry中返回给前端
		for(Club c : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Club", c);
			json.add(jsonObject);
		}
		write(response, json.toString());
	}
	
	/**
	 * 展示所有社团审核通过的文章
	 * @param request
	 * @param response
	 */
	public void showArticles(HttpServletRequest request, HttpServletResponse response) {
		List<Article> list = new RootService().showArticles();
		JSONArray json = new JSONArray();
		
		//多少文章
		JSONObject jsonObjectLen = new JSONObject();
		jsonObjectLen.put("size", list.size());
		json.add(jsonObjectLen);
		
		//将list中的文章 添加到 JSONArry中返回给前端
		for(Article a : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Article", a);
			json.add(jsonObject);
		}
		write(response, json.toString());
		
	}
	
	/**
	 * 展示所有社团审核通过的前num个文章
	 * 参数: num
	 * @param request
	 * @param response
	 */
	public void showNumArticles(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		int num = (int)map.get("num");
		
		List<Article> list = new RootService().showNumArticles(num);
		JSONArray json = new JSONArray();
		
		//多少文章
		JSONObject jsonObjectLen = new JSONObject();
		jsonObjectLen.put("size", list.size());
		json.add(jsonObjectLen);
		
		//将list中的文章 添加到 JSONArry中返回给前端
		for(Article a : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Article", a);
			json.add(jsonObject);
		}
		write(response, json.toString());
	}
	
	/**
	 * 展示所有社团审核通过的活动
	 * @param request
	 * @param response
	 */
	public void showActions(HttpServletRequest request, HttpServletResponse response) {
		List<Action> list = new RootService().showActions();
		JSONArray json = new JSONArray();
		
		//多少活动
		JSONObject jsonObjectLen = new JSONObject();
		jsonObjectLen.put("size", list.size());
		json.add(jsonObjectLen);
		
		//将list中的活动 添加到 JSONArry中返回给前端
		for(Action a : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Action", a);
			json.add(jsonObject);
		}
		write(response, json.toString());
	}
	
	/**
	 * 展示num个审核通过的活动
	 * 参数: num
	 * @param request
	 * @param response
	 */
	public void showNumActions(HttpServletRequest request, HttpServletResponse response) {
		//解析参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		int num = (int)map.get("num");
		
		List<Action> list = new RootService().showNumActions(num);
		JSONArray json = new JSONArray();
		
		//展示num个活动
		JSONObject jsonObjectLen = new JSONObject();
		jsonObjectLen.put("size", list.size());
		json.add(jsonObjectLen);
		
		//将list中的活动 添加到 JSONArry中返回给前端
		for(Action a : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Action", a);
			json.add(jsonObject);
		}
		write(response, json.toString());
		
	}
}
