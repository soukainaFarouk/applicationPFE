package com.example.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Balise;
import com.example.model.Champ;
import com.example.model.Critere;
import com.example.model.RequestChamp;
import com.example.model.Service;
import com.example.model.Table;
import com.example.repository.ChampRequestRepo;
import com.example.repository.ServiceRepo;

@RestController
public class MainService {

	@Autowired
	private ServiceRepo serviceRepo;
	
	@Autowired
	private ChampRequestRepo champRequestRepo;

	@RequestMapping("/")
	public String hello() {
		Service service = serviceRepo.getOne(1L);
		Map<String, String> map = new HashMap<>();
		map.put("customerNumber", "1082458");
		map.put("code", "001");

		System.out.println("********************* Requests *********************");
		service.getBalises().forEach(b -> {
			if (b.getChamp() != null && b.getCriteres().size() > 0) {
				Champ champ = b.getChamp();
				Table table = champ.getTable();
				String req = "select " + champ.getNom() + " from " + table.getNom() + " where";
				List<Critere> criteres = b.getCriteres();
				for (int i = 0; i < criteres.size(); i++) {
					Critere critere = criteres.get(i);
					Balise c = critere.getCritere();
					if (i == 0) {
						if (critere.isNom()) {
							req += " cacc = '" + map.get(c.getNom()) + "' and ctab = '" + critere.getCtab() + "'";
						} else {
							req += " " + c.getChamp().getNom() + " = " + map.get(c.getNom());
						}
					} else {
						if (critere.isNom()) {
							req += " and cacc = '" + map.get(c.getNom()) + "' and ctab = '" + critere.getCtab() + "'";
						} else {
							req += " and " + c.getChamp().getNom() + " = " + map.get(c.getNom());
						}
					}
				}
				System.out.println(req + ";");
			}
		});
		System.out.println("***************************");
		return service.getNom();
	}

	// @RequestMapping("/nodes")
	// public String nodes() throws Exception {
	// Map<String, String> map = new HashMap<>();
	// Scanner in = new Scanner(new File("request.properties"));
	// List<String> flow = new ArrayList<>();
	// while (in.hasNextLine()) {
	// String line = in.nextLine();
	// if (line.split("=").length > 1)
	// map.put(line.split("=")[0], line.split("=")[1]);
	// }
	// in = new Scanner(new File("flow.txt"));
	// while (in.hasNextLine()) {
	// flow.add(in.nextLine());
	// }
	// System.out.println("**********************************");
	// for (int i = 0; i < flow.size(); i++) {
	// if (map.get(flow.get(i)) != null)
	// System.out.println(flow.get(i) + " = " + map.get(flow.get(i)));
	// }
	//
	// Service service = serviceRepo.getOne(1L);
	// List<Balise> balises = service.getBalises();
	// int size = 0;
	// int[] inDegree = new int[1000];
	// Balise[] nodes = new Balise[1000];
	// List<Balise> aide = new ArrayList<>();
	//
	// for (Balise balise : balises) {
	// if (balise.getChamp() != null) {
	// inDegree[size] = balise.getCriteres().size();
	// nodes[size] = balise;
	// aide.add(balise);
	// size++;
	// }
	// }
	// boolean[] v = new boolean[size];
	// // get info from request
	// for (int i = 0; i < size; i++) {
	// if (inDegree[i] == 0 && !v[i]) {
	// inDegree[i]--;
	// System.out.println(nodes[i].getNom() + " from request flow : " +
	// map.get(nodes[i].getNom()));
	// for (int j = 0; j < size; j++) {
	// if (i != j) {
	// List<Critere> criteres = nodes[j].getCriteres();
	// for (Critere c : criteres) {
	// if (c.getCritere().getNom().equals(nodes[i].getNom())) {
	// inDegree[j]--;
	// v[j] = true;
	// }
	// }
	// }
	// }
	// aide.remove(nodes[i]);
	// }
	// }
	//
	// while (!aide.isEmpty()) {
	// for (int i = 0; i < size; i++) {
	// if (inDegree[i] == 0) {
	// Balise b = nodes[i];
	// Champ champ = b.getChamp();
	// Table table = champ.getTable();
	// String req = "select " + champ.getNom() + " from " + table.getNom() + "
	// where";
	// for (int j = 0; j < b.getCriteres().size(); j++) {
	// Critere critere = b.getCriteres().get(j);
	// Balise c = critere.getCritere();
	// if (j == 0) {
	// if (critere.isNom()) {
	// req += " cacc = '" + map.get(c.getNom()) + "' and ctab = '" +
	// critere.getCtab() + "'";
	// } else {
	// req += " " + c.getChamp().getNom() + " = " + map.get(c.getNom());
	// }
	// } else {
	// if (critere.isNom()) {
	// req += " and cacc = '" + map.get(c.getNom()) + "' and ctab = '" +
	// critere.getCtab()
	// + "'";
	// } else {
	// req += " and " + c.getChamp().getNom() + " = " + map.get(c.getNom());
	// }
	// }
	// }
	// System.out.println(b.getNom() + " : " + req + ";");
	// for (int j = 0; j < size; j++) {
	// if (i != j) {
	// List<Critere> criteres2 = nodes[j].getCriteres();
	// for (Critere c : criteres2) {
	// if (c.getCritere().getNom().equals(nodes[i].getNom())) {
	// inDegree[j]--;
	// }
	// }
	// }
	// }
	// aide.remove(b);
	// }
	// }
	// }
	// in.close();
	// return "done";
	// }

	@RequestMapping("/piste2/{id}")
	public String piste2(@PathVariable Long id) throws Exception {
		Map<String, String> map = new HashMap<>();
		Service service = serviceRepo.getOne(id);
		Scanner in = new Scanner(new File("request_" + service.getNom() + ".properties"));
		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (line.split("=").length > 1)
				map.put(line.split("=")[0], line.split("=")[1]);
		}
		in.close();
		String req = "select * from " + service.getTablePrincipale() + " where ";

		List<RequestChamp> requestChamps = service.getRequestChamps();
		int size = 0;
		int[] inDegree = new int[1000];
		RequestChamp[] nodes = new RequestChamp[1000];
		List<RequestChamp> aide = new ArrayList<>();

		Map<String, String> rq = new HashMap<>();
		for (RequestChamp requestChamp : requestChamps) {
			if (!requestChamp.isResponse()) {
				rq.put(requestChamp.getChamp(), requestChamp.getChamp() + " in (?)");
				inDegree[size] = requestChamp.getDependances().size();
				nodes[size] = requestChamp;
				aide.add(requestChamp);
				System.out.println(requestChamp.getChamp() + " : " + inDegree[size]);
				size++;
			}
		}
		int added = 0;
		while (!aide.isEmpty()) {
			for (int i = 0; i < size; i++) {
				if (inDegree[i] == 0) {
					inDegree[i]--;
					RequestChamp r = nodes[i];
					String value = map
							.get(r.getId() + "_" + r.getBalise() + "_" + r.getChamp() + "_" + r.isMemeTable());
					if (value != null) {
						rq.put(r.getChamp(), r.getChamp() + " in (?)");
						if (r.isMemeTable()) {

							if (added == 0)
								req += r.getChamp() + " = '" + value + "'";
							else
								req += " and " + r.getChamp() + " = '" + value + "'";
							added++;
						} else {
							if (!r.isNom()) {
								RequestChamp parent = r.getParent();
								String s = rq.get(parent.getChamp());
								String tmp = "select " + parent.getCle() + " from " + r.getTab() + " where "
										+ r.getChamp() + " = '" + value + "'";
								String tmpWithInterr = "select " + parent.getCle() + " from " + r.getTab() + " where "
										+ r.getChamp() + " in (?)";
								if (added == 0)
									req += s.replaceAll("\\?", tmp);
								else
									req += " and " + s.replaceAll("\\?", tmp);
								added++;
								rq.put(r.getChamp(), s.replaceAll("\\?", tmpWithInterr));
								// rq.put(r.getChamp(), r.getChamp() + " = (?)");
							} else {
								RequestChamp parent = r.getParent();
								String s = rq.get(parent.getChamp());
								String tmp = "select cacc from bknom where " + r.getChamp() + " ='" + value
										+ "' and ctab = '" + r.getCtab() + "'";
								if (added == 0)
									req += s.replaceAll("\\?", tmp);
								else
									req += " and " + s.replaceAll("\\?", tmp);
								added++;
							}
						}
					} else {
						if (!r.isMemeTable()) {
							RequestChamp parent = r.getParent();
							String s = rq.get(parent.getChamp());
							String tmpWithInterr = "select " + parent.getCle() + " from " + r.getTab() + " where "
									+ r.getChamp() + " in (?)";

							rq.put(r.getChamp(), s.replaceAll("\\?", tmpWithInterr));
						}
					}
					for (int j = 0; j < size; j++) {
						if (i != j) {
							RequestChamp c = nodes[j];
							if (c.getDependances().contains(r)) {
								inDegree[j]--;
								nodes[j].setParent(r);
							}
						}
					}
					aide.remove(r);
				}
			}
		}
		return req;
	}

	public String result(String in) {
		return "<div style= 'font-size: 15px; width: 70%; text-align: justify; line-height: 2; margin: 100px auto; padding: 25px; background: #000; color: #fff;'>"
				+ in + "</div>";
	}

	@RequestMapping("/prepareFile/{id}")
	public String prepareFile(@PathVariable Long id) throws Exception {
		Service service = serviceRepo.getOne(id);
		Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("request_" + service.getNom() + ".properties"), "utf-8"));
		writer.flush();
		for (RequestChamp re : service.getRequestChamps()) {
			writer.append(re.getId() + "_" + re.getBalise() + "_" + re.getChamp() + "_" + re.isMemeTable() + "=\n");
		}
		writer.close();

		return "done";
	}
	
	@RequestMapping("xpath/{id}")
	public List<String> getBalises(@PathVariable Long id) {
		List<String> list = new ArrayList<>();
		Service service = serviceRepo.getOne(id);
		List<RequestChamp> requestChamps = champRequestRepo.findByResponseAndService(true,service);
		requestChamps.forEach(re -> list.add(re.getId()+":"+re.getBalise()+":"+re.isMemeTable()));
		Collections.sort(list);
		return list;
	}
	
	@RequestMapping("champ/{id}/{balise}")
	public String champ(@PathVariable Long id,@PathVariable String balise) {
		Service service = serviceRepo.getOne(id);
		RequestChamp champ = champRequestRepo.findByServiceAndBalise(service, balise);
		if(champ.isMemeTable())
			return champ.getChamp();
		if(champ.isNom()) {
			return "select "+champ.getChamp()+" from bknom where cacc = '?' and ctab = '"+champ.getCtab()+"'-"+champ.getDependances().get(0).getBalise();
		}
		String request = "select "+champ.getChamp()+" from "+champ.getTab();
		List<RequestChamp> dep = champ.getDependances();
		for (int i = 0; i < dep.size(); i++) {
			String s = " "+dep.get(i).getCle()+" = '?'";
			if(i == 0)
				request += " where"+s;
			else
				request += " and"+s;
		}
		
		for (int i = 0; i < dep.size(); i++) {
			request += "-"+dep.get(i).getBalise();
		}
		return request;
	}
	
}
