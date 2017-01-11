package springDemos;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class CollectionDemo {
	private List<String> name;
	private Set<String> cities;
	private Map<String, Double> grade;
	private Properties prop;
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public void setGrade(Map<String, Double> grade) {
		this.grade = grade;
	}
	public void run(){
		System.out.println("你的朋友是：");
		for(String n : name){
			System.out.println(n);
		}
		System.out.println("所在城市是：");
		for(String city : cities){
			System.out.println(city);
		}
		System.out.println("成绩是：");
		Set<Entry<String, Double>> g = grade.entrySet();
		for(Entry<String, Double> e : g){
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		System.out.println("properties:");
		Set<Entry<Object, Object>> p = prop.entrySet();
		for(Entry<Object, Object> e : p){
			System.out.println((String)e.getKey() + ":" + (String)e.getValue());
		}
	}
	
}
