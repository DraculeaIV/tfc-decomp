/*     */ package com.bioxx.tfc.ASM;
/*     */ import com.bioxx.tfc.TFCASMLoadingPlugin;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.tree.AbstractInsnNode;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.InsnList;
/*     */ import org.objectweb.asm.tree.JumpInsnNode;
/*     */ import org.objectweb.asm.tree.LabelNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ 
/*     */ public class ClassTransformer implements IClassTransformer {
/*  18 */   public static final Logger LOG = LogManager.getLogger("TerraFirmaCraft ASM");
/*  19 */   protected Map<String, Patch> mcpMethodNodes = new HashMap<String, Patch>();
/*  20 */   protected Map<String, Patch> obfMethodNodes = new HashMap<String, Patch>();
/*     */   
/*     */   protected String mcpClassName;
/*     */   
/*     */   protected String obfClassName;
/*     */   
/*     */   public static int numInsertions;
/*     */   
/*     */   public byte[] transform(String name, String transformedName, byte[] bytes) {
/*  29 */     if (name.equals(this.obfClassName))
/*     */     {
/*  31 */       return transform(bytes);
/*     */     }
/*  33 */     if (name.equals(this.mcpClassName))
/*     */     {
/*  35 */       return transform(bytes);
/*     */     }
/*     */     
/*  38 */     return bytes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] transform(byte[] bytes) {
/*  44 */     ClassNode classNode = new ClassNode();
/*  45 */     ClassReader classReader = new ClassReader(bytes);
/*  46 */     classReader.accept((ClassVisitor)classNode, 0);
/*  47 */     LOG.info("Attempting to Transform: " + classNode.name + " | Found " + getMethodNodeList().size() + " injections");
/*     */     
/*  49 */     Iterator<MethodNode> methods = classNode.methods.iterator();
/*  50 */     while (methods.hasNext()) {
/*     */       
/*  52 */       MethodNode m = methods.next();
/*  53 */       if (getMethodNodeList().containsKey(m.name + " | " + m.desc)) {
/*     */         
/*  55 */         numInsertions = 0;
/*  56 */         Patch mPatch = getMethodNodeList().get(m.name + " | " + m.desc);
/*  57 */         List<InstrSet> instructions = mPatch.instructions;
/*  58 */         InstrSet target = null;
/*  59 */         if (!instructions.isEmpty()) {
/*     */           
/*  61 */           target = instructions.get(0);
/*     */         } else {
/*  63 */           LOG.error("Error in: {" + m.name + " | " + m.desc + "} No Instructions");
/*     */         } 
/*     */         
/*  66 */         if (mPatch.opType == PatchOpType.Modify) {
/*     */           
/*  68 */           for (int index = 0; index < m.instructions.size() && !instructions.isEmpty(); index++)
/*     */           {
/*  70 */             numInsertions = 0;
/*  71 */             while (target != null)
/*     */             {
/*  73 */               if (target.startLine == -1) {
/*  74 */                 performDirectOperation(m.instructions, target);
/*  75 */                 instructions.remove(0);
/*  76 */               } else if (isLineNumber(m.instructions.get(index), target.startLine)) {
/*  77 */                 performAnchorOperation(m.instructions, target, index);
/*  78 */                 instructions.remove(0);
/*     */               } else {
/*     */                 break;
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  86 */               if (!instructions.isEmpty()) {
/*     */                 
/*  88 */                 target = instructions.get(0);
/*     */                 
/*     */                 continue;
/*     */               } 
/*  92 */               target = null;
/*     */             }
/*     */           
/*     */           }
/*     */         
/*  97 */         } else if (mPatch.opType == PatchOpType.Replace) {
/*     */ 
/*     */           
/* 100 */           if (target != null && target.offset != -1)
/*     */           {
/* 102 */             for (int i = 0; i < m.instructions.size(); ) {
/*     */               
/* 104 */               if (i > target.offset) {
/* 105 */                 m.instructions.remove(m.instructions.get(i)); continue;
/* 106 */               }  i++;
/*     */             } 
/*     */           }
/*     */           
/* 110 */           for (int index = 0; index < m.instructions.size() && !instructions.isEmpty(); index++) {
/*     */             
/* 112 */             numInsertions = 0;
/* 113 */             while (target != null) {
/*     */               
/* 115 */               if (target.startLine == -1) {
/* 116 */                 performDirectOperation(m.instructions, target);
/* 117 */                 instructions.remove(0);
/* 118 */               } else if (isLineNumber(m.instructions.get(index), target.startLine)) {
/* 119 */                 performAnchorOperation(m.instructions, target, index);
/* 120 */                 instructions.remove(0);
/*     */               } else {
/*     */                 break;
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 128 */               if (!instructions.isEmpty()) {
/*     */                 
/* 130 */                 target = instructions.get(0);
/*     */                 
/*     */                 continue;
/*     */               } 
/* 134 */               target = null;
/*     */             } 
/*     */             
/* 137 */             m.instructions.add((AbstractInsnNode)new InsnNode(177));
/*     */           } 
/*     */         } 
/* 140 */         LOG.info("Inserted: " + classNode.name + " : {" + m.name + " | " + m.desc + "}");
/*     */       } 
/*     */     } 
/* 143 */     LOG.info("Attempting to Transform: " + classNode.name + " Complete");
/* 144 */     ClassWriter writer = new ClassWriter(1);
/* 145 */     classNode.accept((ClassVisitor)writer);
/* 146 */     return writer.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   private int findLine(InsnList methodList, int line) {
/* 151 */     for (int index = 0; index < methodList.size(); index++) {
/*     */       
/* 153 */       if (isLineNumber(methodList.get(index), line))
/*     */       {
/* 155 */         return index;
/*     */       }
/*     */     } 
/* 158 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void performDirectOperation(InsnList methodInsn, InstrSet input) {
/* 188 */     AbstractInsnNode current = methodInsn.get(input.offset + numInsertions);
/* 189 */     switch (input.opType) {
/*     */       
/*     */       case InsertAfter:
/* 192 */         numInsertions += input.iList.size();
/* 193 */         methodInsn.insert(current, input.iList);
/*     */         break;
/*     */       case InsertBefore:
/* 196 */         numInsertions += input.iList.size();
/* 197 */         methodInsn.insertBefore(current, input.iList);
/*     */         break;
/*     */       case Remove:
/* 200 */         numInsertions--;
/* 201 */         methodInsn.remove(current);
/*     */         break;
/*     */       case Replace:
/* 204 */         if (current instanceof JumpInsnNode && input.iList.get(0) instanceof JumpInsnNode)
/*     */         {
/* 206 */           ((JumpInsnNode)input.iList.get(0)).label = ((JumpInsnNode)current).label;
/*     */         }
/* 208 */         methodInsn.insert(current, input.iList);
/* 209 */         methodInsn.remove(current);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void performAnchorOperation(InsnList methodInsn, InstrSet input, int anchor) {
/*     */     int otherAnchor;
/* 218 */     AbstractInsnNode other, current = methodInsn.get(anchor + input.offset + numInsertions);
/* 219 */     if (input.iList.get(0) instanceof JumpInsnNode)
/*     */     {
/* 221 */       input.iList.set(input.iList.get(0), (AbstractInsnNode)new JumpInsnNode(input.iList.get(0).getOpcode(), (LabelNode)current.getPrevious()));
/*     */     }
/* 223 */     switch (input.opType) {
/*     */       
/*     */       case InsertAfter:
/* 226 */         numInsertions += input.iList.size();
/* 227 */         methodInsn.insert(current, input.iList);
/*     */         break;
/*     */       case InsertBefore:
/* 230 */         numInsertions += input.iList.size();
/* 231 */         methodInsn.insertBefore(current, input.iList);
/*     */         break;
/*     */       case Remove:
/* 234 */         numInsertions--;
/* 235 */         methodInsn.remove(current);
/*     */         break;
/*     */       case Replace:
/* 238 */         methodInsn.insert(current, input.iList);
/* 239 */         methodInsn.remove(current);
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case Switch:
/* 246 */         otherAnchor = findLine(methodInsn, input.offsetLine);
/* 247 */         other = methodInsn.get(otherAnchor + input.offsetSwitch + numInsertions);
/* 248 */         methodInsn.remove(current);
/* 249 */         methodInsn.insert(other, current);
/* 250 */         current = methodInsn.get(anchor + input.offset + numInsertions);
/* 251 */         methodInsn.remove(other);
/* 252 */         methodInsn.insertBefore(current, other);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<String, Patch> getMethodNodeList() {
/* 261 */     if (TFCASMLoadingPlugin.runtimeDeobf)
/*     */     {
/* 263 */       return this.obfMethodNodes;
/*     */     }
/* 265 */     return this.mcpMethodNodes;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isLineNumber(AbstractInsnNode current, int line) {
/* 270 */     if (current instanceof LineNumberNode) {
/*     */       
/* 272 */       int l = ((LineNumberNode)current).line;
/* 273 */       if (l == line)
/*     */       {
/* 275 */         return true;
/*     */       }
/*     */     } 
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class InstrSet
/*     */   {
/*     */     public InsnList iList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int offset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 356 */     public int startLine = -1;
/*     */ 
/*     */ 
/*     */     
/*     */     public ClassTransformer.InstrOpType opType;
/*     */ 
/*     */ 
/*     */     
/* 364 */     public int offsetSwitch = -1;
/* 365 */     public int offsetLine = -1;
/*     */ 
/*     */     
/*     */     public InstrSet(InsnList list, int off, ClassTransformer.InstrOpType op) {
/* 369 */       this.iList = list;
/* 370 */       this.offset = off;
/* 371 */       this.opType = op;
/*     */     }
/*     */     
/*     */     public InstrSet(AbstractInsnNode node, int off, ClassTransformer.InstrOpType op) {
/* 375 */       this.iList = new InsnList();
/* 376 */       this.iList.add(node);
/* 377 */       this.offset = off;
/* 378 */       this.opType = op;
/*     */     }
/*     */     
/*     */     public InstrSet(InsnList list, int startLineNum, int off, ClassTransformer.InstrOpType op) {
/* 382 */       this.iList = list;
/* 383 */       this.startLine = startLineNum;
/* 384 */       this.offset = off;
/* 385 */       this.opType = op;
/*     */     }
/*     */     
/*     */     public InstrSet(AbstractInsnNode node, int startLineNum, int off, ClassTransformer.InstrOpType op) {
/* 389 */       this.iList = new InsnList();
/* 390 */       this.iList.add(node);
/* 391 */       this.startLine = startLineNum;
/* 392 */       this.offset = off;
/* 393 */       this.opType = op;
/*     */     }
/*     */     
/*     */     public InstrSet(int startLineNum, int off, int swLineNum, int swOffset) {
/* 397 */       this.startLine = startLineNum;
/* 398 */       this.offset = off;
/* 399 */       this.opType = ClassTransformer.InstrOpType.Switch;
/* 400 */       this.offsetSwitch = swOffset;
/* 401 */       this.offsetLine = swLineNum;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class Patch
/*     */   {
/*     */     public List<ClassTransformer.InstrSet> instructions;
/*     */     
/* 411 */     public ClassTransformer.PatchOpType opType = ClassTransformer.PatchOpType.Modify;
/*     */ 
/*     */     
/*     */     public Patch(List<ClassTransformer.InstrSet> set) {
/* 415 */       this.instructions = set;
/*     */     }
/*     */ 
/*     */     
/*     */     public Patch(List<ClassTransformer.InstrSet> set, ClassTransformer.PatchOpType op) {
/* 420 */       this.instructions = set;
/* 421 */       this.opType = op;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum PatchOpType
/*     */   {
/* 427 */     Modify,
/* 428 */     Replace;
/*     */   }
/*     */   
/*     */   public enum InstrOpType
/*     */   {
/* 433 */     InsertAfter,
/* 434 */     InsertBefore,
/* 435 */     Switch,
/* 436 */     Replace,
/* 437 */     Remove;
/*     */   }
/*     */   
/*     */   public class JumpNode extends JumpInsnNode {
/*     */     public int line;
/*     */     
/*     */     public JumpNode(int opcode, LabelNode label) {
/* 444 */       super(opcode, label);
/*     */     }
/*     */ 
/*     */     
/*     */     public JumpNode(int opcode, int labelLine) {
/* 449 */       super(opcode, null);
/* 450 */       this.line = labelLine;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ASM\ClassTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */