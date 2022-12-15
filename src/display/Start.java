package display;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Start extends JPanel implements ActionListener{
        
    private JPanel jp_bg , jp_group_name;
    private JLabel jl_name_please , jl_show_name, jl_highscore , jl_highscore_max ,  jl_nameGame;
    private JButton start , how_to_play;
    private JTextField jtf_name;
    
    public Start(ActionListener main) {
         jp_bg = new JPanel();//bg-111133
         jl_nameGame = new JLabel(); // Devs Vs Zombs
         jp_group_name = new JPanel();
         jl_name_please = new JLabel(); //กรอกชื่อ
         jtf_name = new JTextField(); // "   " 
         jl_show_name = new JLabel();
         start = new JButton();
         how_to_play = new JButton();
         jl_highscore = new JLabel();
        jl_highscore_max = new JLabel(); //แสดง score สูงสุด
        
          jp_bg.setBackground(new Color(17, 17, 51));
        jp_bg.setToolTipText("");
        jp_bg.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jp_bg.setFont(new Font("TH SarabunPSK", 1, 18)); // NOI18N
        jp_bg.setPreferredSize(new Dimension(1000, 600));

        start.setBackground(new Color(51, 136, 119));
        start.setFont(new Font("TH SarabunPSK", 3, 36)); // NOI18N
        start.setForeground(new Color(255, 255, 255));
        start.setText("start");
        start.setBorder(null);
        start.addActionListener(main);

        how_to_play.setBackground(new Color(51, 136, 119));
        how_to_play.setFont(new Font("TH SarabunPSK", 1, 36)); // NOI18N
        how_to_play.setForeground(new Color(255, 255, 255));
        how_to_play.setText("How to play");
        how_to_play.setBorder(null);
        how_to_play.addActionListener(this);

        jp_group_name.setBackground(new Color(17, 17, 51));

        jl_name_please.setBackground(new Color(255, 255, 255));
        jl_name_please.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jl_name_please.setForeground(new Color(255, 255, 255));
        jl_name_please.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_name_please.setText("กรุณากรอกชื่อของท่าน");

       GroupLayout jp_group_nameLayout = new GroupLayout(jp_group_name);
        jp_group_name.setLayout(jp_group_nameLayout);
        jp_group_nameLayout.setHorizontalGroup(
            jp_group_nameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jp_group_nameLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jp_group_nameLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_name)
                    .addComponent(jl_name_please, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jp_group_nameLayout.setVerticalGroup(
            jp_group_nameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jp_group_nameLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_name_please)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jl_nameGame.setBackground(new Color(51, 136, 119));
        jl_nameGame.setFont(new Font("TH SarabunPSK", 3, 60)); // NOI18N
        jl_nameGame.setForeground(new Color(51, 136, 119));
        jl_nameGame.setHorizontalAlignment(SwingConstants.CENTER);
        jl_nameGame.setText("Devs Vs Zombs");

        jl_show_name.setFont(new Font("TH SarabunPSK", 0, 24)); // NOI18N
        jl_show_name.setForeground(new java.awt.Color(255, 255, 255));
        jl_show_name.setHorizontalAlignment(SwingConstants.CENTER);
        jl_show_name.setText("รอ logo");

        jl_highscore.setFont(new Font("TH SarabunPSK", 1, 24)); // NOI18N
        jl_highscore.setForeground(new Color(255, 255, 255));
        jl_highscore.setText("Highscore :");

        jl_highscore_max.setFont(new Font("TH SarabunPSK", 1, 24)); // NOI18N
        jl_highscore_max.setForeground(new Color(255, 255, 255));
        jl_highscore_max.setText("แสดงคะแนนสูงสุด");

        GroupLayout jp_bgLayout = new GroupLayout(jp_bg);
        jp_bg.setLayout(jp_bgLayout);
        jp_bgLayout.setHorizontalGroup(
            jp_bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jp_bgLayout.createSequentialGroup()
                .addGroup(jp_bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jp_bgLayout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jl_nameGame, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_bgLayout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addGroup(jp_bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(start, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                            .addComponent(how_to_play, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_bgLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jl_show_name, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jp_group_name, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(302, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jp_bgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jl_highscore, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_highscore_max)
                .addGap(32, 32, 32))
        );
        jp_bgLayout.setVerticalGroup(
            jp_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_bgLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jl_nameGame, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_show_name, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jp_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(how_to_play, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jp_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_highscore)
                    .addComponent(jl_highscore_max))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp_bg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp_bg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>                   

    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource().equals(how_to_play)){
            jl_show_name.setText("How To Play");
//            removeContent(); //เอาออก--
//            HowToPlay howtoplay = new HowToPlay(); 
//            this.getContentPane().add(howtoplay); //เปิดใหม่
//            howtoplay.requestFocus();
        }
//        if(ae.getSource().equals(start)){
//            jl_show_name.setText(jtf_name.getText());
//        }
    }

        

}