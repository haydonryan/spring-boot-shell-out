package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	public String directory() {
		String r="";

		String cmd = "ls -l BOOT-INF/";
		Runtime run = Runtime.getRuntime();
		try {
			Process pr = run.exec(cmd);

			pr.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
				r += line +"\r\n";
			}
		} catch (Exception i) {
			System.out.println("failed");
		}

		return r;

	}
	
	
	public String cfmgmt() {
		String r="";

		String cmd = "BOOT-INF/classes/cfmgmt";
		Runtime run = Runtime.getRuntime();
		try {
			Process pr = run.exec(cmd);

			pr.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
				r += line +"\r\n";
			}
		} catch (Exception i) {
			System.out.println("failed");
		}

		return r;

	}
	
	public String git() {
		String r="";

		String cmd = "git clone https://github.com/haydonryan/fortune-teller";
		Runtime run = Runtime.getRuntime();
		try {
			Process pr = run.exec(cmd);

			pr.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
				r += line +"\r\n";
			}
		} catch (Exception i) {
			System.out.println("failed");
		}

		return r;

	}

    @RequestMapping("/")
    public String index() {
    		
        return "Greetings from Spring Boot!" + "\n\n" + directory() + "\n\n" + cfmgmt() + git(); 
    }

}