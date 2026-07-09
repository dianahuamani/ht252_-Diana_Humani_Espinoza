package dianahuamaniespinoza.view;


import javax.swing.*;


public class FrmPrincipal extends JFrame {


    private JButton btnCurso;
    private JButton btnMatricula;
    private JButton btnSalir;



    public FrmPrincipal(){


        initComponents();


        eventos();


    }




    private void initComponents(){


        setTitle("Sistema de Matrícula de Cursos");


        setSize(400,300);


        setLayout(null);


        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );



        JLabel titulo =
                new JLabel(
                        "Sistema de Matrícula"
                );


        titulo.setBounds(
                120,
                30,
                200,
                30
        );


        add(titulo);




        btnCurso =
                new JButton(
                        "Gestión Cursos"
                );


        btnCurso.setBounds(
                100,
                80,
                200,
                40
        );


        add(btnCurso);





        btnMatricula =
                new JButton(
                        "Gestión Matrículas"
                );


        btnMatricula.setBounds(
                100,
                130,
                200,
                40
        );


        add(btnMatricula);






        btnSalir =
                new JButton(
                        "Salir"
                );


        btnSalir.setBounds(
                100,
                180,
                200,
                40
        );


        add(btnSalir);


    }







    private void eventos(){



        btnCurso.addActionListener(e -> {


            FrmCurso ventana =
                    new FrmCurso();


            ventana.setLocationRelativeTo(null);


            ventana.setVisible(true);


        });






        btnMatricula.addActionListener(e -> {


            FrmMatricula ventana =
                    new FrmMatricula();


            ventana.setLocationRelativeTo(null);


            ventana.setVisible(true);


        });







        btnSalir.addActionListener(e -> {


            System.exit(0);


        });



    }


}