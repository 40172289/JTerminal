import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JTerminal extends JTextArea{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String[][] grid;
	public int lines=10;
	public int columns=10;
	
	public JTerminal(int l, int c){
		columns = c;
		lines = l;
		grid = buildGrid();
		createWindow();
	}
	
	public JTerminal(){
		grid = buildGrid();
		createWindow();
	}
	
	protected void createWindow(){
		Font font = new Font("Courier", Font.BOLD, 12);
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setWrapStyleWord(true);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.white);
		this.setFont(font);
		this.setColumns(columns);
		this.setRows(lines);
		this.setEditable(false);
		f.add(this);
		f.setResizable(false);
		f.setLocation(100, 100);
		f.pack();
		f.setVisible(true);
	}
	
	protected String[][] buildGrid(){
		String[][] grid = new String[lines][columns];
		for(int i=0;i<lines;i++){
			for(int x=0;x<columns;x++){
				grid[i][x] = " ";
			}
		}
		return grid;
	}
	
	public void clearGrid(){
		for(int i=0;i<lines;i++){
			for(int x=0;x<columns;x++){
				grid[i][x] = " ";
			}
		}
	}
	
	public void drawBox(int line, int column, int width, int height){
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				try{
					putChar("#", line+i, column+j);
				}
				catch(Exception e){
					
				}
			}
		}
		for(int i=1;i<height-1;i++){
			for(int j=1;j<width-1;j++){
				try{
					putChar(" ", line+i, column+j);
				}
				catch(Exception e){
					
				}
			}
		}
	}
	
	public void putString(String s, int line, int column){
		for(int i=0;i<s.length();i++){
			putChar(Character.toString(s.charAt(i)), line, column+i);
		}
	}
	
	public void fillBox(int line, int column, int width, int height){
		
	}
	
	public void display(){
		String s = "";
		for(int i=0;i<this.lines;i++){
			for(int j=0;j<this.columns;j++){
				s+=grid[i][j];
			}
			s += "\n";
		}
		this.setText(s);
	}
	
	public void putChar(String Char, int line, int column){
		grid[line][column] = Char;
	}
}
