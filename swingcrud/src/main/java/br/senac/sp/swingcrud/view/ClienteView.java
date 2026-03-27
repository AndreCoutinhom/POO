package br.senac.sp.swingcrud.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClienteView extends JFrame {
    private JLabel lbID;
    private JTextField tfID;
    private JLabel lbNome;
    private JTextField tfNome;
    private JLabel lbEmail;
    private JTextField tfEmail;
    private JLabel lbEndereco;
    private JTextField tfEndereco;

    private JPanel pnBotoes;
    private JButton btSalvar;
    private JButton btExcluir;
    private JButton btLimpar;

    public ClienteView() {
        //  Título da janela
        setTitle("CRUD Cliente");

        // Tamanho da janela
        setSize(700,500);

        // O Tipo de fechamento da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Em que parte da tela a janela aparece. Colocando null, a posição é o centro da tela.
        setLocationRelativeTo(null);
        setResizable(false); // Janela não pode ter a dimensão alterada.

        setLayout(null); // Com o layout nulo, podemos alterar o layout da forma como queremos...

        //lbID: Todas as configurações de visibilidade do elemento de rótulo.
        lbID = new JLabel("Id:"); // Conteúdo
        lbID.setBounds(10, 10, 50, 30); // ... como aqui. Tamanho e dimensionamento
        lbID.setForeground(Color.BLUE); // Cor do texto
//        lbID.setOpaque(true); // Configuração necessária para habilitar a mudança na cor de fundo.
//        lbID.setBackground(Color.CYAN); // Cor do fundo

        //tdID: Todas as configurações de visibilidade do elemento de campo de texto.
        tfID = new JTextField("1"); // Conteúdo
        tfID.setBounds(100, 10, 50, 30); // Tamanho
        tfID.setHorizontalAlignment(SwingConstants.CENTER); // Alinhamento Horizontal
        tfID.setEditable(false); // Faz com que a caixa de texto não seja editável.
        tfID.setEnabled(false); // Faz com que a caixa de texto nem mesmo interaja com o cursor.

        //lbNome
        lbNome = new JLabel("Nome:"); // Conteúdo
        lbNome.setBounds(10, 50, 50, 30); // ... como aqui. Tamanho e dimensionamento
        lbNome.setForeground(Color.BLUE); // Cor do texto
//        lbNome.setOpaque(true); // Configuração necessária para habilitar a mudança na cor de fundo.
//        lbNome.setBackground(Color.WHITE); // Cor do fundo

        //tfNome
        tfNome = new JTextField(); // Conteúdo
        tfNome.setBounds(100, 50, 200, 30); // Tamanho
        tfNome.setHorizontalAlignment(SwingConstants.LEFT); // Alinhamento Horizontal
        tfNome.setEditable(true); // Faz com que a caixa de texto não seja editável.
        tfNome.setEnabled(true); // Faz com que a caixa de texto nem mesmo interaja com o cursor.


        //lbEmail
        lbEmail = new JLabel("Email:"); // Conteúdo
        lbEmail.setBounds(10, 90, 50, 30); // ... como aqui. Tamanho e dimensionamento
        lbEmail.setForeground(Color.BLUE); // Cor do texto
//        lbEmail.setOpaque(true); // Configuração necessária para habilitar a mudança na cor de fundo.
//        lbEmail.setBackground(Color.WHITE); // Cor do fundo

        //tfEmail
        tfEmail = new JTextField(); // Conteúdo
        tfEmail.setBounds(100, 90, 200, 30); // Tamanho
        tfEmail.setHorizontalAlignment(SwingConstants.LEFT); // Alinhamento Horizontal
        tfEmail.setEditable(true); // Faz com que a caixa de texto não seja editável.
        tfEmail.setEnabled(true); // Faz com que a caixa de texto nem mesmo interaja com o cursor.

        //lbEndereco
        lbEndereco = new JLabel("Endereço:"); // Conteúdo
        lbEndereco.setBounds(10, 130, 80, 30); // ... como aqui. Tamanho e dimensionamento
        lbEndereco.setForeground(Color.BLUE); // Cor do texto
//        lbEmail.setOpaque(true); // Configuração necessária para habilitar a mudança na cor de fundo.
//        lbEmail.setBackground(Color.WHITE); // Cor do fundo

        //tfEndereco
        tfEndereco = new JTextField(); // Conteúdo
        tfEndereco.setBounds(100, 130, 300, 100); // Tamanho
        tfEndereco.setHorizontalAlignment(SwingConstants.LEFT); // Alinhamento Horizontal
        tfEndereco.setEditable(true); // Faz com que a caixa de texto não seja editável.
        tfEndereco.setEnabled(true); // Faz com que a caixa de texto nem mesmo interaja com o cursor.

        //botões
        btSalvar = new JButton("Salvar");
        btExcluir = new JButton("Excluir");
        btLimpar = new JButton("Limpar");

        //pnBotoes
        pnBotoes = new JPanel();
        pnBotoes.add(btSalvar);
        pnBotoes.add(btExcluir);
        pnBotoes.add(btLimpar);
        pnBotoes.setBounds(10,250,370,50);


        // Adicionando componentes
        getContentPane().add(lbID);
        getContentPane().add(tfID);
        getContentPane().add(lbNome);
        getContentPane().add(tfNome);
        getContentPane().add(lbEmail);
        getContentPane().add(tfEmail);
        getContentPane().add(lbEndereco);
        getContentPane().add(tfEndereco);
        getContentPane().add(pnBotoes);

    }

    // Este método recebe um listener vinculado ao botão Salvar da classe ClienteController
    public void addListenerSalvar(ActionListener listener) {
        btSalvar.addActionListener(listener); // Vinculamos o botão salvar o com a interface que o transforma em um ouvinte.
        // A view só vincula
    }

    public String getNome() {
        return tfNome.getText();
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public String getEndereco() {
        return tfEndereco.getText();
    }

}
