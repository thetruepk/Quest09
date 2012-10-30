package edu.unca.jlmccask.Quest08.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListStore {
	
	private File storagFile;
	private ArrayList<String> values;
	
	public ListStore(File file){
		this.storagFile = file;
		this.values = new ArrayList<String>();
		
		if (this.storagFile.exists() == false){
			try {
				this.storagFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
	public void load(){
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.storagFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		
			String line, value;
			
			
				while ((line = reader.readLine())!= null){
					if(this.values.contains(line) == false){
						this.values.add(line);
					}
				}
				input.close();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	
		
		
		
	}
	
	public void save(){
		try {
				
			FileWriter stream = new FileWriter(this.storagFile);
			BufferedWriter out = new BufferedWriter(stream);
			for(String value : this.values){
				out.write(value);
				out.newLine();
				
			}
			out.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public boolean contains(String value){
		return this.values.contains(value);
	}
	
	public void add(String value){
		if(contains(value) == false){
		this.values.add(value);
		}
	}
	
	public void remove(String value){
	 this.values.remove(value);	
	}
	
	public ArrayList<String> getValues(){
		return this.values;
	}
	





}
	

