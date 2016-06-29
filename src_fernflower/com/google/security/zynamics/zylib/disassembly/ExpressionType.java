package com.google.security.zynamics.zylib.disassembly;

public enum ExpressionType {
   SYMBOL,
   IMMEDIATE_INTEGER,
   IMMEDIATE_FLOAT,
   OPERATOR,
   REGISTER,
   SIZE_PREFIX,
   MEMDEREF,
   EXPRESSION_LIST;
}
