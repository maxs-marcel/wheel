package fun.maxs.wheel.entity.vo.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoListVO implements Serializable {

    private static final long serialVersionUID = 2483795273964965829L;

    private String name;
    private Integer age;
}
