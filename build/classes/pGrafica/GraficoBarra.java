package pGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JFrame implements ActionListener  {
    private JButton botao;
    private double mediaSequential=0, mediaBinary; 
    private double iter =0,n;

    public void setN(double n) {
        this.n = n;
    }

    public double getMediaSequential() {
        return mediaSequential;
    }

    public void setMediaSequential(double mediaSequential) {
        this.mediaSequential = mediaSequential;
    }

    public double getMediaBinary() {
        return mediaBinary;
    }

    public void setMediaBinary(double mediaBinary) {
        this.mediaBinary = mediaBinary;
    }


    public void setIter(double tam) {
        this.iter = tam;
    }
    
    public GraficoBarra(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gráfico de Desempenho dos Tipos de Busca");
        setSize(900,685);
        setLocationRelativeTo(null); 
        botao = new JButton();
        botao.addActionListener(this);
        setVisible(true);    
    }
    private ChartPanel criaGrafico(String titulo){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        barra.setValue(mediaSequential, "Sequential Search", "");
        barra.setValue(mediaBinary, "Binary Search", "");
        
        JFreeChart grafico = ChartFactory.createBarChart3D(titulo, "Tipos de Busca", "Tempo em milisegundos", barra,PlotOrientation.VERTICAL,true,false,false);
        
        CategoryPlot barraItem = grafico.getCategoryPlot();
        //barraItem.getRenderer().setSeriesPaint(2, Color.MAGENTA);
        ChartPanel painel = new ChartPanel(grafico);
        return painel;    
    }
    
     void criaPágina(){
         String titulo =  "Desempenho médio de "+ n + " até " + n*iter + " chaves";
         JPanel painel = new JPanel();
            painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
            this.botao.setSize(100,100);
            this.botao.setText("Voltar");
            JPanel grafico = new JPanel();
            grafico= criaGrafico(titulo);
            
        
        painel.add(grafico);
        painel.add(this.botao);
        
        add(painel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      new Input().setVisible(true);
      this.dispose();
      //botao.setText("Voltar2");
    }
    
    public static void main(String[] args) {
        new GraficoBarra();
    }
}
