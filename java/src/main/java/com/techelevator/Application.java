package com.techelevator;


import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchEngine;
import com.techelevator.util.TELog;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		try {
			TELog teLog = new TELog();

			teLog.log("Search application started.");

			SearchDomain searchDomain = new SearchDomain("data");
			teLog.log(searchDomain.toString());

			SearchEngine searchEngine = new SearchEngine(searchDomain);
			searchEngine.indexFiles();

			List<String> filesWithSingleSearchWord = searchEngine.search("The");
			printResults(filesWithSingleSearchWord);

			List<String> filesWithMultipleSearchWords = searchEngine.search("telephone line");
			printResults(filesWithMultipleSearchWords);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printResults(List<String> filesWithSearchWord){
		if(filesWithSearchWord.size() == 0){
			System.out.println("No matching files found.");
		}else{
			for(String file : filesWithSearchWord){
				System.out.println(file);

			}
		}
	}
}
