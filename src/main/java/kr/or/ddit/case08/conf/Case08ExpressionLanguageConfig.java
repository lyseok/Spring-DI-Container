package kr.or.ddit.case08.conf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import kr.or.ddit.case08.objs.DestVO;
import kr.or.ddit.case08.objs.OriginalVO;

/**
 * @Value
 */
@Configuration
public class Case08ExpressionLanguageConfig {
  
  @Bean
  public List<String> list(){
    return List.of("값1", "값2");
  }
  
  @Bean
  public List<String> nonUseList(){
    return new ArrayList<String>();
  }
  
  @Bean
  public Map<String, Object> map(){
    return Map.of("key1", "value1", "key-2", "value2");
  }
  
  @Bean
  public OriginalVO original(
        List<String> list
        , Map<String, Object> map
        , @Value("텍스트") String str
        , @Value("classpath:logback.xml") Resource res
        , @Value("34") int number
      ) {
    return new OriginalVO(list, map, null, res, number);
  };
  
  @Bean
  public DestVO dest(
//        @Value("#{original.str ?: '기본값'}") String str
	    @Value("#{T(org.apache.commons.lang3.StringUtils).isNoneBlank(original.str) ? original.str : '기본값'}") String str
        , @Value("#{original['res']}") Resource res
        , @Value("#{T(kr.or.ddit.case08.objs.OriginalVO).staticNumber * 10}") int number
//        , @Value("#{original.list[1]}") String secondStr
        , @Value("#{original.list.get(1)}") String secondStr
        , @Value("#{original.map.get('key1')}") String key1Value
        , @Value("#{original.map['key-2']}") String key2Value
        , @Value("#{T(java.time.LocalDate).now()}") LocalDate today
        , @Value("#{T(java.time.LocalDateTime).now()}") LocalDateTime now
        
      ) {
    return new DestVO(str, res, number, secondStr, key1Value, key2Value, today, now);
  }
  
}
