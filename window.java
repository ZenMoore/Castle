package castle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class window extends JFrame{
	/**
	 * Pic
	 */
	private JPanel picPanel=new JPanel();
	/**
	 * container
	 */
	private Container container=this.getContentPane();
	/**
	 * Text Area & ScrollPane
	 */
	private JScrollPane scrollPanel=new JScrollPane();
	private JTextArea area=new JTextArea();
	/**
	 * command
	 */
	private JTextField field=new JTextField();
	
	public window(){
		this.setContainer();
		this.setWindow();
	}
	
	public void setContainer(){
		container.setLayout(new GridLayout(3,1,10,10));
		field.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				 if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {	
					 Game.switchCase(window.this.getField());
				  }
			}
		});
		scrollPanel.add(area);
		scrollPanel.getViewport();
		container.add(picPanel);
		container.add(scrollPanel);
		container.add(field);
	}
	
	public void setWindow(){
		this.setTitle("Castle");
		this.setSize(600, 600);
		this.setBackground(Color.gray);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void setField(String content){
		this.field.setText(content);
	}
	public String getField(){
		return this.field.getText();
	}
	public void setArea(String content){
		this.area.setText(content);
	}
	
	public static void main(String[] args) {
		Game.run();
	}

}
