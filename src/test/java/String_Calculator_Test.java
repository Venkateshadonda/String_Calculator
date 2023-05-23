import Incubytes.assessment.String_Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class String_Calculator_Test {
    @Test
    void should_return_zero_for_empty_string(){
        Assertions.assertThat(String_Calculator.Add("")).isEqualTo(0);
    }
    @Test
    void should_return_number_for_one_number(){
        Assertions.assertThat(String_Calculator.Add("6")).isEqualTo(6);
    }
    @Test
    void should_return_sum_of_two_numbers(){
        Assertions.assertThat(String_Calculator.Add("6,2")).isEqualTo( 8);
    }
    @Test
    void should_return_sum_of_unknown_amount_of_numbers(){
        Assertions.assertThat(String_Calculator.Add("1,2,3")).isEqualTo(6);
    }
    @Test
    void should_return_sum_of_numbers_split_by_commas_and_new_lines(){
        Assertions.assertThat(String_Calculator.Add("1,4\n3")).isEqualTo(8);
    }
    @Test
    void should_return_sum_of_numbers_split_by_custom_delimiter(){
        Assertions.assertThat(String_Calculator.Add("//;\n1;2;3")).isEqualTo(6);
    }
    @Test
    void should_throw_exception_for_comma_nest_to_new_line(){
        Assertions.assertThatThrownBy(()->String_Calculator.Add("2,\n3"))
                .isInstanceOf(NumberFormatException.class);
    }
    @Test
    void should_throw_exception_for_negatives(){
        Assertions.assertThatThrownBy(()->String_Calculator.Add("1,-2,3,-4"))
                .hasMessageContaining("Negative Values Not Allowed ")
                .hasMessageContaining("-2 -4");
    }

}

