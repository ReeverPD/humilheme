package com.reever.humilheme.to;

import com.reever.humilheme.entity.User;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author iuriandreazza
 */
public class UserTO implements Serializable {
    
    @Getter @Setter
    private Long idUser;
    
    @Getter @Setter
    private String username;
    
    
    @Getter @Setter
    private String code;
    
}
