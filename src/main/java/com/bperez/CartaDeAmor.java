package com.bperez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartaDeAmor extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public CartaDeAmor() {
        setTitle("Carta de Amor");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Pantalla inicial
        JPanel panelInicio = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(255, 204, 204));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.RED);
                g.setFont(new Font("Serif", Font.BOLD, 36));
                g.drawString("💖 Feliz Día Mi Princesita 💖", 150, 100);
                g.drawImage(new ImageIcon("hellokitty.png").getImage(), 500, 20, 150, 150, this);
            }
        };
        panelInicio.setLayout(new BorderLayout());
        JButton botonSiguiente = new JButton("❤ Siguiente ❤") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.PINK);
                g.fillOval(20, 10, 60, 60);
                g.fillOval(80, 10, 60, 60);
                g.fillPolygon(new int[]{20, 140, 80}, new int[]{50, 50, 140}, 3);
            }
        };

        botonSiguiente.setContentAreaFilled(false);
        botonSiguiente.setBorderPainted(false);
        botonSiguiente.setFocusPainted(false);

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "mensaje");
            }
        });
        panelInicio.add(botonSiguiente, BorderLayout.SOUTH);

        // Segunda pantalla con mensaje de amor
        JPanel panelMensaje = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(255, 182, 193));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.RED);
                g.drawRect(100, 100, 600, 200);
                g.setFont(new Font("Serif", Font.ITALIC, 24));
                g.drawString("💖 Eres la razón de mis sonrisas y mis mejores días 💖", 120, 150);
                g.drawString("Que tengas un lindo día, te amo mucho 💕", 180, 200);
                //g.drawImage(new ImageIcon("hellokitty.png").getImage(), 500, 20, 150, 150, this);
                g.drawString("🌷🌷🌷🌷🌷🌷🌷🌷🌷🌷", 100, 95);
                g.drawString("🌷🌷🌷🌷🌷🌷🌷🌷🌷🌷", 100, 310);
            }
        };
        panelMensaje.setLayout(new BorderLayout());

        JButton botonCerrar = new JButton("❤ Cerrar ❤") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.PINK);
                g.fillOval(20, 10, 60, 60);
                g.fillOval(80, 10, 60, 60);
                g.fillPolygon(new int[]{20, 140, 80}, new int[]{50, 50, 140}, 3);
            }
        };
        
        botonCerrar.setContentAreaFilled(false);
        botonCerrar.setBorderPainted(false);
        botonCerrar.setFocusPainted(false);

        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelMensaje.add(botonCerrar, BorderLayout.SOUTH);

        panelPrincipal.add(panelInicio, "inicio");
        panelPrincipal.add(panelMensaje, "mensaje");
        
        add(panelPrincipal);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CartaDeAmor());
    }
}