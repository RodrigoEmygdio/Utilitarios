package org.emygdio.utilitarios.cast;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

class CastTest {

    Optional valor = Optional.empty();

     @Test
    public void devera_retornar_valor_com_cast_informado() throws BancoobException {
        ParametroCastUtil<Integer> objectCast = ParametroCastUtil.newInstance();
        Number retorno = objectCast.castValor(valor, Integer.class);
        assertThat(retorno, instanceOf(Integer.class));
    }

    @Test
    public void devera_retronar_valores_padrao_para_Numbers() throws BancoobException {
        ParametroCastUtil<Integer> objectCast = ParametroCastUtil.newInstance();
        Number retorno = objectCast.castValor(valor, Integer.class);
        assertThat(retorno, is(equalTo(0)));

    }

    @Test
    public void devera_retornar_valor_padrao_para_Strings() throws BancoobException {
        ParametroCastUtil<String> objectCast = ParametroCastUtil.newInstance();
        String retorno = objectCast.castValor(valor, String.class);
        assertThat(retorno.length(), is(equalTo(0)));
    }

    @Test
    public void devera_retornar_valor_padrao_para_Long() throws BancoobException {
        ParametroCastUtil<Long> objectCast = ParametroCastUtil.newInstance();
        Long retorno = objectCast.castValor(valor, Long.class);
        assertThat(retorno, is(equalTo(0L)));
    }

    @Test
    public void devera_retornar_valor_padrao_para_Number() throws BancoobException {
       ParametroCastUtil<Number>  obj = ParametroCastUtil.newInstance();
       Number retorno = obj.castValor(valor, Number.class);
       assertThat(retorno, is(equalTo(0)));
    }

    @Test(expected = NegocioException.class)
    public void deverar_fazer_cast_string_para_Number() throws BancoobException {
        Object valor = "1";
        ParametroCastUtil<Number> castUtil = ParametroCastUtil.newInstance();
        Number retorno = castUtil.castValor(Optional.of(valor), Number.class) ;
    }

    @Test
    public  void deverar_fazer_cast_string_para_Integer() throws BancoobException {
        Object valor = "1";
        ParametroCastUtil<Integer> castUtil = ParametroCastUtil.newInstance();
        Integer retorno = castUtil.castValor(Optional.of(valor), Integer.class);
        assertThat(retorno, is(equalTo(1)));

    }

    @Test
    public void deverar_retornar_valor_padrao_para_Date() throws BancoobException {
        ParametroCastUtil<Date> objetoCast = ParametroCastUtil.newInstance();
        Date retorno = objetoCast.castValor(valor, Date.class);
        assertThat(retorno, is(nullValue()));
    }

    @Test
    public void devera_retronar_valor_padrao_para_Boolean() throws BancoobException {
        ParametroCastUtil<Boolean> objetoCast = ParametroCastUtil.newInstance();
        Boolean retorno = objetoCast.castValor(valor, Boolean.class);
       assertFalse(retorno);
    }


    private Object getValorNumber() {
        return 10;
    }


}
