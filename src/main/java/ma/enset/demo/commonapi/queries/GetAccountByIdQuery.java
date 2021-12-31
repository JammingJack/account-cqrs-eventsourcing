package ma.enset.demo.commonapi.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class GetAccountByIdQuery {
    private String id;

}
