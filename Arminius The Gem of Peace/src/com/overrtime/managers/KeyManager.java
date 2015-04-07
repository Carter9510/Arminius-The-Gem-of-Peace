package com.overrtime.managers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.overrtime.game.Display;
import com.overrtime.game.developers.Console;
import com.overrtime.mechanics.Checkpoint;
import com.overrtime.world.Level;
import com.overrtime.world.entities.Player;
import com.overrtime.world.items.Sword;

public class KeyManager implements KeyListener {

	boolean shift = false;

	public static boolean use = false;

	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();

		if (keycode == KeyEvent.VK_W) {
			Player.up = true;
		}
		if (keycode == KeyEvent.VK_S) {
			Player.dn = true;
			if (Player.aup == false) {
				Player.aup = true;
			}
		}
		if (keycode == KeyEvent.VK_A) {
			Player.lt = true;
			Player.moving = true;
		}
		if (keycode == KeyEvent.VK_D) {
			if (!shift) {
				Player.rt = true;
			}
		}

		if (Player.dead & keycode == KeyEvent.VK_R) {
			if (Checkpoint.hasCheckpoint()) {
				Checkpoint.setPlace();
			}
		}

		if (Player.dead & keycode == KeyEvent.VK_Q) {
			System.exit(0);
		}

		if (keycode == KeyEvent.VK_C) {
			new Console();
		}

		if (keycode == KeyEvent.VK_P) {
			if (!Display.pause) {
				Display.pause = true;
				Player.cu = false;
				Player.cd = false;
				Player.cl = false;
				Player.cr = false;
			} else {
				Display.pause = false;
				Player.cu = true;
				Player.cd = true;
				Player.cl = true;
				Player.cr = true;
			}
		}

		if (keycode == KeyEvent.VK_SHIFT) {
			Player.isShifting = true;
		}

		if (keycode == KeyEvent.VK_B) {
			try {

				final String username = "vitalgamingzone@gmail.com";
				final String password = "tikitikit";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				final Session session = Session.getInstance(props,
						new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});

				final JFrame frame = new JFrame("Arminius Bug Reporter");
				frame.setSize(200, 200);
				frame.setLocationRelativeTo(null);
				frame.setLayout(new BorderLayout());
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

				final JTextArea jep = new JTextArea();
				jep.setWrapStyleWord(true);
				jep.setLineWrap(true);

				JScrollPane jsp = new JScrollPane(jep);

				frame.add(jsp, BorderLayout.CENTER);

				JButton send = new JButton("Send");

				final String name = JOptionPane.showInputDialog(null, "Please Enter Your Email!", "Email!", JOptionPane.NO_OPTION);
				System.out.println(name);
				
				send.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						try {
							Message message = new MimeMessage(session);
							message.setFrom(new InternetAddress(name));
							message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("vitalgamingzone@gmail.com"));
							message.setSubject("Bug Report!");
							message.setText("From:" + name + "\n\n" +jep.getText());
							Transport.send(message);

							JOptionPane.showMessageDialog(null,
									"Bug Report Sent!");

							frame.hide();
						} catch (AddressException e1) {
							e1.printStackTrace();
						} catch (MessagingException e1) {
							e1.printStackTrace();
						}

					}
				});

				frame.add(send, BorderLayout.SOUTH);

				frame.setVisible(true);
			} catch (Exception ee) {
				ee.printStackTrace();
			}

		}

		if (keycode == KeyEvent.VK_Z) {
			Display.screenshot = true;
		}

		if (keycode == KeyEvent.VK_SPACE) {
			use = true;
		}


		if (keycode == KeyEvent.VK_K) {
			Sword.slice = true;
		}
		
		if(Player.dead && keycode == KeyEvent.VK_R) {
			Player.dead = false;
			Player.health = 100;
			LevelManager.setCurrentLevel(new Level(Display.getTextures().level), "Town", 100, 100);
		}

	}

	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();

		if (keycode == KeyEvent.VK_W) {
			Player.up = false;
			Player.moving = false;
		}
		if (keycode == KeyEvent.VK_S) {
			Player.dn = false;
			Player.moving = false;
		}
		if (keycode == KeyEvent.VK_A) {
			Player.lt = false;
			Player.moving = false;
		}
		if (keycode == KeyEvent.VK_D) {
			Player.rt = false;
			Player.moving = false;
		}
		if (keycode == KeyEvent.VK_SHIFT) {
			Player.isShifting = false;
		}
		if (keycode == KeyEvent.VK_SPACE) {
			use = false;
		}

	}

	public void keyTyped(KeyEvent e) {

	}

}