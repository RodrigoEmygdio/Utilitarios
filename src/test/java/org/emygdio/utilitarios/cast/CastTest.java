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
    public void devera_retornar_valor_com_cast_informado() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Cast<Integer> objectCast = Cast.newInstance();
        Number retorno = objectCast.castValor(valor, Integer.class);
        assertThat(retorno, instanceOf(Integer.class));
    }

    @Test
    void devera_retronar_valores_padrao_para_Numbers() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Cast<Integer> objectCast = Cast.newInstance();
        Number retorno = objectCast.castValor(valor, Integer.class);
        assertThat(retorno, is(equalTo(0)));

    }

    @Test
    void devera_retornar_valor_padrao_para_Strings() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Cast<String> objectCast = Cast.newInstance();
         String retorno = objectCast.castValor(valor, String.class);
        assertThat(retorno, is(Matchers.emptyString()));
    }


    private Object getValorNumber() {
        return 10;
    }


}