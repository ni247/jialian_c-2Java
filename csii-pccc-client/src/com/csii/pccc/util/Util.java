package com.csii.pccc.util;

import java.util.Collection;
import java.util.Map;

public abstract class Util
{
  public static boolean isEmptywithTrim(String string)
  {
    return ((string == null) || (string.trim().length() == 0));
  }

  public static boolean isEmpty(String string)
  {
    return ((string == null) || (string.length() == 0));
  }

  public static boolean isEmpty(Object[] array)
  {
    return ((array == null) || (array.length == 0));
  }

  public static boolean isEmpty(Collection collection)
  {
    return ((collection == null) || (collection.isEmpty()));
  }

  public static boolean isEmpty(Map map)
  {
    return ((map == null) || (map.isEmpty()));
  }
}
