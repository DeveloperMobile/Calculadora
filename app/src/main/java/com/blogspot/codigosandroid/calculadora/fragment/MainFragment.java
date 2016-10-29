package com.blogspot.codigosandroid.calculadora.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.blogspot.codigosandroid.calculadora.R;
import com.blogspot.codigosandroid.calculadora.utils.AlertUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    /* duas variávies do tipo double pra efetuar as operações */
    private double operador1;
    private double operador2;

    /* variável do tipo String que armazena as operações */
    private String operadores;

    /* componente de texto para o visor da calculadora */
    private EditText txt_visor;
    /* String auxiliar para preencher o visor */
    private String aux = null;

    /* componentes button que para o teclado numérico da calculadora */
    private Button bt_0;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;

    /* componente button, para inserir um ponto no visor pra operações
     * com números decimais */
    private Button bt_ponto;

    /* componentes button para realizar as as quatro operações matemáticas */
    private Button bt_soma;
    private Button bt_subt;
    private Button bt_multi;
    private Button bt_divi;

    /* componente button para gerar o resultado */
    private Button bt_igual;

    /* componente button para limpar o visor da calculadora */
    private Button bt_limpar;

    /* componente button que fecha o aplicativo */
    private Button bt_sair;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        inicializar(view);
        listeners();
        return view;

    }

    /* Inicializa os componentes da tela */

    private void inicializar(View view) {

        txt_visor = (EditText) view.findViewById(R.id.txt_visor);

        bt_0 = (Button) view.findViewById(R.id.bt_0);
        bt_1 = (Button) view.findViewById(R.id.bt_1);
        bt_2 = (Button) view.findViewById(R.id.bt_2);
        bt_3 = (Button) view.findViewById(R.id.bt_3);
        bt_4 = (Button) view.findViewById(R.id.bt_4);
        bt_5 = (Button) view.findViewById(R.id.bt_5);
        bt_6 = (Button) view.findViewById(R.id.bt_6);
        bt_7 = (Button) view.findViewById(R.id.bt_7);
        bt_8 = (Button) view.findViewById(R.id.bt_8);
        bt_9 = (Button) view.findViewById(R.id.bt_9);

        bt_soma = (Button) view.findViewById(R.id.bt_soma);
        bt_subt = (Button) view.findViewById(R.id.bt_subt);
        bt_multi = (Button) view.findViewById(R.id.bt_multi);
        bt_divi = (Button) view.findViewById(R.id.bt_divi);

        bt_ponto = (Button) view.findViewById(R.id.bt_ponto);
        bt_igual = (Button) view.findViewById(R.id.bt_igual);
        bt_limpar = (Button) view.findViewById(R.id.bt_limpar);
        bt_sair = (Button) view.findViewById(R.id.bt_sair);

    }

	/* Trata os eventos dos componentes da tela */
    private void listeners() {

        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);

        bt_soma.setOnClickListener(this);
        bt_subt.setOnClickListener(this);
        bt_multi.setOnClickListener(this);
        bt_divi.setOnClickListener(this);

        bt_ponto.setOnClickListener(this);
        bt_limpar.setOnClickListener(this);
        bt_sair.setOnClickListener(this);
        bt_igual.setOnClickListener(this);

    }

    /* Função para o teclado numérico */
    private void tecladoNumerico(int leNumero) {

        if (txt_visor.getText().toString().trim().equals("0.0")) {

            limparVisor();
            String textvisor = txt_visor.getText().toString();
            String numero = String.valueOf(leNumero);
            aux = textvisor + numero;
            txt_visor.setText(aux);

        } else {

            String textvisor = txt_visor.getText().toString();
            String numero = String.valueOf(leNumero);
            aux = textvisor + numero;
            txt_visor.setText(aux);

        }

    }

    /* Função para inserção do ponto */
    private void ponto(String ponto){

        String textvisor = txt_visor.getText().toString();
        txt_visor.setText(textvisor + ponto);

    }

    /* Função para limpar o visor */
    private void limparVisor() {

        txt_visor.setText("");

    }

    private void operacoes(String operadores) {

        this.operadores = operadores;

        if (operadores == "+") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "-") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "*") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "/") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        }

    }

    private void igual() {

        if(!txt_visor.getText().toString().trim().equals("")){

            if (operadores == "+") {

                operador2 = operador1 + Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "-") {

                operador2 = operador1 - Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "*") {

                operador2 = operador1 * Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "/") {

                if(operador1 == 0){

                    operador2 = 0;

                } else {

                    operador2 = operador1 / Double.parseDouble(txt_visor.getText().toString().trim());

                }

            }

        }else{

            operador2 = 0;

        }

        txt_visor.setText(String.valueOf(operador2));

    }

    /** Haviam alguns erros no método onclick onde as chamadas 'id.bt_x' não estavam
     * sendo reconhecias. Isso acontece, pois o id reference do componente fica armazenado
     * na classe R do projeto e o caminho o pacote dessa classe não estava
     * declarado no topo da classe (import com.blogspot.codigosandroid.calculadora.R),
     * mas também pode ser feito como está abaixo "classe.atributo_identificaror.id_componente" */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt_0:

                tecladoNumerico(0);
                break;

            case R.id.bt_1:

                tecladoNumerico(1);
                break;

            case R.id.bt_2:

                tecladoNumerico(2);
                break;

            case R.id.bt_3:

                tecladoNumerico(3);
                break;

            case R.id.bt_4:

                tecladoNumerico(4);
                break;

            case R.id.bt_5:

                tecladoNumerico(5);
                break;

            case R.id.bt_6:

                tecladoNumerico(6);
                break;

            case R.id.bt_7:

                tecladoNumerico(7);
                break;

            case R.id.bt_8:

                tecladoNumerico(8);
                break;

            case R.id.bt_9:

                tecladoNumerico(9);
                break;

            case R.id.bt_limpar:

                limparVisor();
                break;

            case R.id.bt_igual:

                igual();
                break;

            case R.id.bt_ponto:

                ponto(".");
                break;

            case R.id.bt_sair:

                AlertUtils.alert(getActivity(), "Fechar",
                        "Deseja realmente fechar a aplicação:", R.string.sim, new AlertUtils.DialogCallback() {

                            @Override
                            public void dialogcallback() {

                                getActivity().finish();

                            }

                        });
                break;

            case R.id.bt_soma:

                operacoes("+");
                break;

            case R.id.bt_subt:

                operacoes("-");
                break;

            case R.id.bt_multi:

                operacoes("*");
                break;

            case R.id.bt_divi:

                operacoes("/");
                break;

        }

    }

}
