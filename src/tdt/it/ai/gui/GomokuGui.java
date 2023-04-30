/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tdt.it.ai.gui;

/**
 *
 * @author Hoang
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

//import javafx.beans.InvalidationListener;
//import javafx.collections.SetChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import tdt.it.ai.core.Board;
import tdt.it.ai.core.Gomoku;

public class GomokuGui extends javax.swing.JFrame implements Observer {

    private JButton[][] arrBtn;
	private Gomoku gomoku;
	private String messenger;
	private boolean isStart = false;

        private JPanel contentPane;
        private JPanel homePane;
        private JPanel menuPane;
        private JButton btnGoFirst;
        private JButton btnGoSecond;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GomokuGui frame = new
	 * GomokuGui(new Board()); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	
        public GomokuGui(Gomoku gomoku) {
		this.gomoku = gomoku;
		gomoku.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Caro Game");
		setBounds(100, 100, 600, 450);
		setResizable(false);
		setLayout(new BorderLayout());
//		add(createContentPane(), BorderLayout.CENTER);
//		add(createMenuPane(), BorderLayout.EAST);
                add(createHomePane(), BorderLayout.CENTER);
	}
        
        private JPanel createHomePane()
        {
            if(homePane != null) return homePane;
            homePane = new JPanel();
            homePane.setBorder(new EmptyBorder(5, 5, 5, 5));
            homePane.setLayout(new GridLayout(3, 2, 100, 100));
            
            JButton btn1Player = new JButton("1 Player");
            JButton btn2Players = new JButton("2 Players");
            JButton btnQuit = new JButton("Quit");
            
            btnGoFirst = new JButton("Go First");
            btnGoSecond = new JButton("Go Second");
            btnGoFirst.setEnabled(false);
            btnGoSecond.setEnabled(false);
            
            btnQuit.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);

                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            btn1Player.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnGoFirst.setEnabled(true);
                    btnGoSecond.setEnabled(true);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            
            //them code 2 nguoi choi o day
            btn2Players.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    homePane.setVisible(false);
                    if(contentPane == null)
                    {
                        add(createContentPane(), BorderLayout.CENTER);
                        add(createMenuPane(), BorderLayout.EAST);
                    }
                    else
                    {
                        contentPane.setVisible(true);
                        menuPane.setVisible(true);
                    }
                    //
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            btnGoFirst.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    homePane.setVisible(false);
                    if(contentPane == null)
                    {
                        add(createContentPane(), BorderLayout.CENTER);
                        add(createMenuPane(), BorderLayout.EAST);
                    }
                    else
                    {
                        contentPane.setVisible(true);
                        menuPane.setVisible(true);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            btnGoSecond.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    homePane.setVisible(false);
                    if(contentPane == null)
                    {
                        add(createContentPane(), BorderLayout.CENTER);
                        add(createMenuPane(), BorderLayout.EAST);
                    }
                    else
                    {
                        contentPane.setVisible(true);
                        menuPane.setVisible(true);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            
            homePane.add(btn1Player);
            homePane.add(btnGoFirst);
            homePane.add(btn2Players);
            homePane.add(btnGoSecond);
            homePane.add(btnQuit);
            
            return homePane;
        }

	private JPanel createContentPane() {  //tao bang, ma tran de choi
                if(contentPane != null) return contentPane;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(Board.MAX_ROW, Board.MAX_COL));
		arrBtn = new JButton[Board.MAX_ROW][Board.MAX_COL];
		for (int i = 0; i < Board.MAX_ROW; i++) {
			for (int j = 0; j < Board.MAX_COL; j++) {
				int r = i, c = j;
				JButton btn = new JButton();
				btn.setBackground(Color.WHITE);
				btn.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (isStart && gomoku.doClick(r, c))
							/* btn.setBackground(Color.BLACK) */;
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
					}
				});
				arrBtn[i][j] = btn;
				contentPane.add(btn);
			}
		}
		return contentPane;
	}

	private JPanel createMenuPane() { //them home, quit btn
                if(menuPane != null) return menuPane;
		menuPane = new JPanel(new GridLayout(0, 1, 100, 100));
                menuPane.setBorder(new EmptyBorder(10, 5, 10, 5));

                String str = "Start Replay";
                JButton btnHome = new JButton("Home");
		JButton btnReplay = new JButton("<html>" + str.replaceAll("\\n", "<br>") + "</html>");
                JButton btnQuit = new JButton("Quit");
                
                btnHome.setPreferredSize(new Dimension(70, 10));
                btnQuit.setPreferredSize(new Dimension(70, 10));
                btnReplay.setPreferredSize(new Dimension(70, 10));
                
                btnQuit.addMouseListener(new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
//                        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
                            System.exit(0);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                
                });
		btnReplay.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				gomoku.newGame();
				isStart = true;
			}
		});
		btnHome.addMouseListener(new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        contentPane.setVisible(false);
                        menuPane.setVisible(false);
                        homePane.setVisible(true);
                        btnGoFirst.setEnabled(false);
                        btnGoSecond.setEnabled(false);
                        gomoku.newGame();
                        isStart = true;
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                
                });
		menuPane.add(btnReplay);
                menuPane.add(btnHome);
                menuPane.add(btnQuit);

		return menuPane;
	}

	private void setIcon(JButton btn, int _player) {
		/*
		 * if (btn.getIcon() != null) return;
		 */
		Icon icon;
		if (_player == -1) {
			icon = new ImageIcon();
		} else {
			Character c = _player == Gomoku.PLAYER.X.getValue() ? 'x' : 'o';
			icon = new ImageIcon("src\\Img\\" + c + ".png");
		}
		btn.setIcon(icon);
		btn.setBackground(Color.white);
	}

	public void updateMatrix() {
		for (int i = 0; i < Board.MAX_ROW; i++) {
			for (int j = 0; j < Board.MAX_COL; j++) {
				int _player = gomoku.getBoard().getCurrentNode().getState()[i][j];
				setIcon(arrBtn[i][j], _player);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		updateMatrix();
		if (arg1 != null) {
			if (arg1 instanceof String)
				JOptionPane.showMessageDialog(null, (String) arg1);
			else {
				int[] tile = (int[]) arg1;
				arrBtn[tile[0]][tile[1]].setBackground(Color.DARK_GRAY);
			}
		}
	}
    /**
     * Creates new form GomokuGui
     */
    public GomokuGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GomokuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GomokuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GomokuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GomokuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GomokuGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
