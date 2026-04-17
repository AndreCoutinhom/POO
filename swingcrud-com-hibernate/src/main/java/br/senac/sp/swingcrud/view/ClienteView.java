package br.senac.sp.swingcrud.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.senac.sp.swingcrud.model.Cliente;
import br.senac.sp.swingcrud.model.table.ClienteTableModel;

public class ClienteView extends JFrame {
    private JLabel lbId;
    private JLabel lbNome;
    private JLabel lbEmail;
    private JLabel lbEnd;

    private JTextField tfId;
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextArea taEndereco;

    private JPanel pnBotoes;
    private JButton btSalvar;
    private JButton btExcluir;
    private JButton btLimpar;

    private JTable tbCliente;
    private JScrollPane pnCliente;
    private ClienteTableModel tableModel;

    private Cliente cliente;

    public ClienteView() {
        // título da janela
        setTitle("CRUD Cliente");
        // tamanho
        setSize(600, 500);
        // define o tipo de fechamento da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // inicia no centro da tela
        setLocationRelativeTo(null);
        // retira o redimensionamento
        setResizable(false);
        // retira o gerenciador de layout
        setLayout(null);

        // lbId
        lbId = new JLabel("Id:");
        lbId.setBounds(10, 10, 50, 30);
        lbId.setForeground(Color.BLUE);
        // para aparecer cor de fundo, deve-se deixar Opaque true
        lbId.setOpaque(true);

        // tfId
        tfId = new JTextField();
        tfId.setBounds(70, 10, 50, 30);
        // alinhamento horizontal
        tfId.setHorizontalAlignment(SwingConstants.CENTER);
        // sem permissão para editar o conteúdo
        tfId.setEditable(false);

        // lbNome
        lbNome = new JLabel("Nome:");
        lbNome.setBounds(10, 50, 50, 30);
        lbNome.setForeground(Color.BLUE);

        // tfNome
        tfNome = new JTextField();
        tfNome.setBounds(70, 50, 300, 30);

        // lbEmail
        lbEmail = new JLabel("E-mail:");
        lbEmail.setBounds(10, 90, 50, 30);
        lbEmail.setForeground(Color.BLUE);

        // tfEmail
        tfEmail = new JTextField();
        tfEmail.setBounds(70, 90, 300, 30);

        // lbEnd
        lbEnd = new JLabel("End.:");
        lbEnd.setBounds(10, 130, 50, 30);
        lbEnd.setForeground(Color.BLUE);

        // taEnd
        taEndereco = new JTextArea();
        taEndereco.setBounds(70, 130, 300, 60);
        // quebrar a linha ao final
        taEndereco.setLineWrap(true);

        // botões
        btSalvar = new JButton("Salvar");
        btExcluir = new JButton("Excluir");
        btLimpar = new JButton("Limpar");

        // pnBotoes
        pnBotoes = new JPanel();
        pnBotoes.add(btSalvar);
        pnBotoes.add(btExcluir);
        pnBotoes.add(btLimpar);
        pnBotoes.setBounds(10, 200, 370, 50);

        // tableModel
        tableModel = new ClienteTableModel();

        // tbCliente
        tbCliente = new JTable(tableModel);
        tbCliente.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbCliente.getSelectionModel().addListSelectionListener(e -> {
            // Evita um desparo duplo do listener
            if(!e.getValueIsAdjusting()) {
                int linha = tbCliente.getSelectedRow();
                if (linha >= 0) {
                    cliente = tableModel.getClienteAt(linha);
                    preencherCampos();
                }
            }
        });

        // pnCliente
        pnCliente = new JScrollPane(tbCliente);
        pnCliente.setBounds(10,260,575,200);

        // adicionando componentes
        getContentPane().add(lbId);
        getContentPane().add(tfId);
        getContentPane().add(lbNome);
        getContentPane().add(tfNome);
        getContentPane().add(lbEmail);
        getContentPane().add(tfEmail);
        getContentPane().add(lbEnd);
        getContentPane().add(taEndereco);
        getContentPane().add(pnBotoes);
        getContentPane().add(pnCliente);
    }

    public void addListenerSalvar(ActionListener listener) {
        btSalvar.addActionListener(listener);
    }

    public void addListenerExcluir(ActionListener listener) {
        btExcluir.addActionListener(listener);
    }

    public void addListenerLimpar(ActionListener listener) {
        btLimpar.addActionListener(listener);
    }

    public String getNome() {
        return tfNome.getText();
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public String getEndereco() {
        return taEndereco.getText();
    }

    public void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog
                (this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarSucesso(String mensagem) {
        JOptionPane.showMessageDialog
                (this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean confirmaExclusao() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o cliente " + cliente.getNome() + "?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        return opcao == JOptionPane.YES_OPTION;
    }

    public void preencherCampos() {
        if(cliente != null) {
            tfId.setText("" + cliente.getId());
            tfNome.setText(cliente.getNome());
            tfEmail.setText(cliente.getEmail());
            taEndereco.setText(cliente.getEndereco());
        }
    }

    public void limparCampos() {
        tfId.setText(null);
        tfNome.setText(null);
        tfEmail.setText(null);
        taEndereco.setText(null);
        tfNome.requestFocus();
        cliente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ClienteTableModel getTableModel() {
        return tableModel;
    }
}
