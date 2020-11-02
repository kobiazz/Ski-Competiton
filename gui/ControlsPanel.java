package gui;

import game.Builder.CompetitonBuilder;
import game.entities.sportsman.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;


public class ControlsPanel extends JPanel implements ActionListener{
    private final JTextField tfArenaLength;
    private final JTextField tfMaxCompetitors;
    private final JTextField tfCompetitorName;
    private final JTextField tfMaxSpeed;
    private final JTextField tfAcceleration;
    private final JTextField tfAge;
    private final JTextField tfAddAcceleration;
    
    private final JComboBox<String> cmbArenaSurface;
    private final JComboBox<String> cmbArenaWeather;
    private final JComboBox<String> cmbCompetition;
    private final JComboBox<String> cmbDiscipline;
    private final JComboBox<String> cmbLeague;
    private final JComboBox<String> cmbGender;
    private final JComboBox<String>   cmbSeason;
    private final JComboBox<String>   cmbcolor;
    
    private ArenaPanel arenaPanel = null;
 
    
    
    public ControlsPanel(ArenaPanel arenaPanel) {
        this.arenaPanel = arenaPanel;
        setLayout(null);
        setPreferredSize(new Dimension(165,arenaPanel.getArenaLength()));

        
        JLabel l1 = new JLabel("<HTML><font color='blue'><U>BUILD ARENA</U></font></HTML>");
        add(l1);
        l1.setLocation(10,10);
        l1.setSize(145, 20);
        
        JLabel l2 = new JLabel("Arena length");
        l2.setLocation(10,33);
        l2.setSize(145, 15);
        add(l2);
        
        tfArenaLength = new JTextField(""+arenaPanel.getArenaLength());
        tfArenaLength.setLocation(10,50);
        tfArenaLength.setSize(145, 25);
        add(tfArenaLength);   
        
        
        JLabel l4 = new JLabel("Snow surface");
        l4.setLocation(10,78);
        l4.setSize(170, 15);
        add(l4);
        
        cmbArenaSurface = new JComboBox<>();       
        cmbArenaSurface.addItem("Powder");
        cmbArenaSurface.addItem("Crud");
        cmbArenaSurface.addItem("Ice");  
        
        if (arenaPanel.getSurface() != null)
        	cmbArenaSurface.setSelectedItem(arenaPanel.getSurface()); 
        else
        	cmbArenaSurface.setSelectedItem("Powder");
        
        add(cmbArenaSurface);
        cmbArenaSurface.setLocation(10,95);
        cmbArenaSurface.setSize(145,20);
        
        JLabel l5 = new JLabel("Weather condition");
        l5.setLocation(10,118);
        l5.setSize(170, 15);
        add(l5);
        
        cmbArenaWeather = new JComboBox<>();       
        cmbArenaWeather.addItem("Sunny");
        cmbArenaWeather.addItem("Cloudy");
        cmbArenaWeather.addItem("Stormy");  
        
        if (arenaPanel.getWeather() != null)
        	cmbArenaWeather.setSelectedItem(arenaPanel.getWeather()); 
        else
        	cmbArenaWeather.setSelectedItem("Sunny");
        
        add(cmbArenaWeather);
        cmbArenaWeather.setLocation(10,135);
        cmbArenaWeather.setSize(145,20);

        JLabel a = new JLabel("Season");
        a.setLocation(10,158);
         a.setSize(170, 10);
        add(a);

        cmbSeason = new JComboBox<>();
        cmbSeason.addItem("Winter");
        cmbSeason.addItem("Summer");
        add(cmbSeason);
        cmbSeason.setLocation(10,170);
        cmbSeason.setSize(145,20);


        JButton buildArenaBut = new JButton("Build arena");
        buildArenaBut.setLocation(10,186);
        buildArenaBut.setSize(145, 30);
        buildArenaBut.addActionListener(this);
        add(buildArenaBut);
        
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setLocation(0,219);
        sep.setSize(170, 10);
        add(sep);
        
        
        //-------------------------------------------------------------------
        
        JLabel l6 = new JLabel("<HTML><font color='blue'><U>CREATE COMPETITION</U></font></HTML>");
        add(l6);
        l6.setLocation(10,217);
        l6.setSize(145, 20);
        
        JLabel l7 = new JLabel("Choose competition");
        l7.setLocation(10,240);
        l7.setSize(170, 15);
        add(l7);
        
        cmbCompetition = new JComboBox<>();       
        cmbCompetition.addItem("Ski");
        cmbCompetition.addItem("Snowboard");         
        if (arenaPanel.getCompetition() != null)
        	cmbCompetition.setSelectedItem(arenaPanel.getCompetition()); 
        else
        	cmbCompetition.setSelectedItem("Ski");   
        add(cmbCompetition);
        cmbCompetition.setLocation(10,258);
        cmbCompetition.setSize(145,20);
        
        
        JLabel l8 = new JLabel("Max competitors number");
        l8.setLocation(10,281);
        l8.setSize(170, 15);
        add(l8);
        
        tfMaxCompetitors = new JTextField(""+arenaPanel.getMaxCompetitors());
        tfMaxCompetitors.setLocation(10,298);
        tfMaxCompetitors.setSize(145, 25);
        add(tfMaxCompetitors);
        
        
        JLabel l9 = new JLabel("Discipline");
        l9.setLocation(10,326);
        l9.setSize(170, 15);
        add(l9);
        
        cmbDiscipline = new JComboBox<>();       
        cmbDiscipline.addItem("Slalom");
        cmbDiscipline.addItem("Giant-Slalom");
        cmbDiscipline.addItem("Downhill");
        cmbDiscipline.addItem("Freestyle");
        if (arenaPanel.getCompetition() != null)
        	cmbDiscipline.setSelectedItem(arenaPanel.getDiscipline()); 
        else
        	cmbDiscipline.setSelectedItem("Slalom"); 
        add(cmbDiscipline);
        cmbDiscipline.setLocation(10,344);
        cmbDiscipline.setSize(145,20);
        
        
        JLabel l10 = new JLabel("League");
        l10.setLocation(10,367);
        l10.setSize(170, 15);
        add(l10);
        
        cmbLeague = new JComboBox<>();       
        cmbLeague.addItem("Junior");
        cmbLeague.addItem("Adult");
        cmbLeague.addItem("Senior");
        if (arenaPanel.getCompetition() != null)
        	cmbLeague.setSelectedItem(arenaPanel.getLeague()); 
        else
        	cmbLeague.setSelectedItem("Junior");
        add(cmbLeague);
        cmbLeague.setLocation(10,384);
        cmbLeague.setSize(145,20);
        
        
        JLabel l11 = new JLabel("Gender");
        l11.setLocation(10,407);
        l11.setSize(170, 15);
        add(l11);
        
        cmbGender = new JComboBox<>();       
        cmbGender.addItem("Male");
        cmbGender.addItem("Female");
        if (arenaPanel.getCompetition() != null)
        	cmbGender.setSelectedItem(arenaPanel.getGender()); 
        else
        	cmbGender.setSelectedItem("Male");
        add(cmbGender);
        cmbGender.setLocation(10,427);
        cmbGender.setSize(145,20);
        
        JButton createCompetitionBut = new JButton("Create competition");
        createCompetitionBut.setLocation(10,450);
        createCompetitionBut.setSize(145, 30);
        createCompetitionBut.addActionListener(this);
        add(createCompetitionBut);
        
        JSeparator sep2 = new JSeparator(SwingConstants.HORIZONTAL);
        sep2.setLocation(0,484);
        sep2.setSize(170, 10);
        add(sep2);
        
        //-------------------------------------------------------------------------------
        
        JLabel l12 = new JLabel("<HTML><font color='blue'><U>ADD COMPETITOR</U></font></HTML>");
        add(l12);
        l12.setLocation(10,486);
        l12.setSize(145, 20);
        
        JLabel l13 = new JLabel("Name");
        l13.setLocation(10,510);
        l13.setSize(170, 15);
        add(l13);
        
        tfCompetitorName = new JTextField("");
        tfCompetitorName.setLocation(10,526);
        tfCompetitorName.setSize(145, 25);
        add(tfCompetitorName);
        
        JLabel l14 = new JLabel("Age");
        l14.setLocation(10,552);
        l14.setSize(150, 15);
        add(l14);
        
        tfAge = new JTextField("");
        tfAge.setLocation(10,570);
        tfAge.setSize(145, 25);
        add(tfAge);
           
        JLabel l15 = new JLabel("Max speed");
        l15.setLocation(10,597);
        l15.setSize(150, 15);
        add(l15);
        
        tfMaxSpeed = new JTextField("");
        tfMaxSpeed.setLocation(10,615);
        tfMaxSpeed.setSize(145, 25);
        add(tfMaxSpeed);
        
        JLabel l16 = new JLabel("Acceleration");
        l16.setLocation(10,642);
        l16.setSize(150, 15);
        add(l16);
        
        tfAcceleration = new JTextField("");
        tfAcceleration.setLocation(10,660);
        tfAcceleration.setSize(145, 25);
        add(tfAcceleration);

        JLabel tfcolor = new JLabel("Color");
        tfcolor.setLocation(10,680);
        tfcolor.setSize(145, 25);
        add(tfcolor);


        cmbcolor = new JComboBox<>();
        cmbcolor.addItem("red");
        cmbcolor.addItem("blue");
        cmbcolor.addItem("black");
        cmbcolor.addItem("yellow");
        cmbcolor.addItem("white");
        add(cmbcolor);
        cmbcolor.setLocation(10,705);
        cmbcolor.setSize(145,20);

        JLabel tfAddSpeed = new JLabel("Add Acceleration");
        tfAddSpeed.setLocation(10,720);
        tfAddSpeed.setSize(145, 25);
        add(tfAddSpeed);

        tfAddAcceleration = new JTextField();
        tfAddAcceleration.setLocation(10,745);
        tfAddAcceleration.setSize(145, 25);
        add(tfAddAcceleration);

        JButton addCompetitorBut = new JButton("Add competitor");
        addCompetitorBut.setLocation(10,868);
        addCompetitorBut.setSize(70, 30);
        addCompetitorBut.addActionListener(this);
        add(addCompetitorBut);

        JButton changeBut = new JButton("Change");
        changeBut.setLocation(10,828);
        changeBut.setSize(145, 30);
        changeBut.addActionListener(this);
        add(changeBut);

        JButton copyBut = new JButton("Copy");
        copyBut.setLocation(90,868);
        copyBut.setSize(70, 30);
        copyBut.addActionListener(this);
        add(copyBut);

        JButton defBut = new JButton("Default");
        defBut.setLocation(10,780);
        defBut.setSize(145, 30);
        defBut.addActionListener(this);
        add(defBut);

        JSeparator sep3 = new JSeparator(SwingConstants.HORIZONTAL);
        sep3.setLocation(0,902);
        sep3.setSize(170, 10);
        add(sep3);

        //---------------------------------------------

        JButton startCompetitionBut = new JButton("Start competition");
        startCompetitionBut.setLocation(10,908);
        startCompetitionBut.setSize(145, 30);
        startCompetitionBut.addActionListener(this);
        add(startCompetitionBut);

        JButton printInfoBut = new JButton("Show info");
        printInfoBut.setLocation(10,942);
        printInfoBut.setSize(145, 30);
        printInfoBut.addActionListener(this);
        add(printInfoBut);

    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
               
				case "Build arena":  
                    int arenaLength = arenaPanel.getArenaLength();
                    if (arenaPanel.isCompetitionStarted() && !arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition started! Please wait.");
                        return;
                    }
                    try{
                        arenaLength = Integer.parseInt(tfArenaLength.getText());
                        arenaPanel.setArenaLength(arenaLength);
                        if (arenaLength<700 || arenaLength>900) throw new Exception();
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(arenaPanel, "Invalid input values! Please try again.");
                        return;
                    }                  


                    arenaPanel.buildArena((String)cmbSeason.getSelectedItem(),(String)cmbArenaSurface.getSelectedItem(),(String)cmbArenaWeather.getSelectedItem());
                    break;  
                    
				case "Create competition":
					int maxCompetitors = arenaPanel.getMaxCompetitors();
                    if (arenaPanel.isCompetitionStarted() && !arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition started! Please wait.");
                        return;
                    }
                    
                    if (arenaPanel.noArena()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena first!");
                        return;
                    } 
					
                    try{
                        maxCompetitors = Integer.parseInt(tfMaxCompetitors.getText());
                        arenaPanel.setMaxCompetitors(maxCompetitors); 
                        if (maxCompetitors<=0 || maxCompetitors > 20) throw new Exception();
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(arenaPanel, "Invalid input values! Please try again.");
                        return;
                    }
                    
					try {
						arenaPanel.createCompetition((String)cmbCompetition.getSelectedItem(),(String)cmbDiscipline.getSelectedItem(),
								(String)cmbLeague.getSelectedItem(),(String)cmbGender.getSelectedItem());
					} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		                    
					break;
                    
               case "Add competitor":                 
                    if (arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition finished! Please create new competition.");
                        return;
                    }
                    if (arenaPanel.isCompetitionStarted()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition started! No competitors can be added.");
                        return;
                    }
                    if (arenaPanel.noArena()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena first!");
                        return;
                    }   
                    if (arenaPanel.getCompetition() == null) {
                        JOptionPane.showMessageDialog(arenaPanel, "Please create competition first!");
                        return;
                    }
                    if (arenaPanel.fullArena()){
                        JOptionPane.showMessageDialog(arenaPanel, "No more competitors can be added!");
                        return;
                    }
                    String name;
                    double age;
                    double maxSpeed;
                    double acceleration;    
                    try {
                        name = tfCompetitorName.getText();
                        age = Double.parseDouble(tfAge.getText());
                        maxSpeed = Double.parseDouble(tfMaxSpeed.getText());
                        acceleration = Double.parseDouble(tfAcceleration.getText());
                        if (name.isEmpty() || maxSpeed <=0 || acceleration <=0 || age<=0) throw new Exception();
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(arenaPanel, "Invalid input values! Please try again.");
                        return;
                    }
                    
					try {
						arenaPanel.addCompetitor(name, age, maxSpeed, acceleration);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}       
                    break;


               case "Change":
                   String color = cmbcolor.getSelectedItem().toString();
                   double acce;
                   if (tfAddAcceleration.getText().isEmpty())
                       acce=1;
                   else
                   acce = Double.parseDouble(tfAddAcceleration.getText());


                   ColoredSportsman coloredSportsman = new ColoredSportsman(arenaPanel.getCompetitor(),color);
                   SpeedySportsman speedySportsman = new SpeedySportsman(coloredSportsman,acce);
                   try {
                       arenaPanel.updateCompetitor(speedySportsman);
                   } catch (IllegalAccessException e1) {
                       e1.printStackTrace();
                   } catch (NoSuchFieldException e1) {
                       e1.printStackTrace();
                   } catch (IOException e1) {
                       e1.printStackTrace();
                   }
                   break;

            case "Copy":
                try {
                    WinterSportsman proWs = arenaPanel.getCompetitor().clone();
                    arenaPanel.addCompetitor(proWs.getName(),proWs.getAge(),proWs.getMaxSpeed(),proWs.getAcceleration());
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;

            case "Default":
                CompetitonBuilder c = new CompetitonBuilder();
                c.buildArena();
                c.buildCompetition();
                c.buildCompetitor();

                arenaPanel.buildArena(c.arena.getSurface().toString(),c.arena.getSurface().toString(),c.arena.getCondition().toString());
                try {
                    arenaPanel.createCompetition("Ski",c.cmp.getDiscipline().toString(),c.cmp.getLeague().toString(),c.cmp.getGender().toString());
                    for(int i = 0;i<c.cmp.getMaxCompetitors();i++) {
                        arenaPanel.addCompetitor(c.ws.getName(), c.ws.getAge(), c.ws.getMaxSpeed(), c.ws.getAcceleration());
                    }
                  //  arenaPanel.startRace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                }

                break;

                case "Start competition":
                    
                    if (arenaPanel.noArena() || arenaPanel.getCompetition()==null || arenaPanel.noCompetitors()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena, create competition and add competitors!");
                        return;
                    } 
                    if (arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition finished! Please create a new competition and add competitors.");
                        return;
                    }
                    if (arenaPanel.isCompetitionStarted()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition already started!");
                        return;
                    }                  
                    
                    arenaPanel.startRace();
                    break;
                    
                case "Show info":
                    
                    if (arenaPanel.noArena() || arenaPanel.getCompetition()==null || arenaPanel.noCompetitors()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena, create competition and add competitors!");
                        return;
                    } 
                    
                    arenaPanel.showInfo();
                    break;
        }
    }

}
