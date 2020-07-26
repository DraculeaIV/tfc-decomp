/*    */ package com.bioxx.tfc.ASM.Transform;
/*    */ 
/*    */ import com.bioxx.tfc.ASM.ClassTransformer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.FieldInsnNode;
/*    */ import org.objectweb.asm.tree.InsnList;
/*    */ import org.objectweb.asm.tree.MethodInsnNode;
/*    */ import org.objectweb.asm.tree.VarInsnNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TF_EntityRenderer
/*    */   extends ClassTransformer
/*    */ {
/*    */   public TF_EntityRenderer() {
/* 25 */     List<ClassTransformer.InstrSet> nodes = new ArrayList<ClassTransformer.InstrSet>();
/* 26 */     InsnList list = new InsnList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 51 */     list.add((AbstractInsnNode)new FieldInsnNode(180, "net/minecraft/client/renderer/EntityRenderer", "random", "Ljava/util/Random;"));
/* 52 */     list.add((AbstractInsnNode)new VarInsnNode(25, 0));
/* 53 */     list.add((AbstractInsnNode)new FieldInsnNode(180, "net/minecraft/client/renderer/EntityRenderer", "rendererUpdateCount", "I"));
/* 54 */     list.add((AbstractInsnNode)new MethodInsnNode(184, "com/bioxx/tfc/ClientOverrides", "doRainClient", "(Ljava/util/Random;I)V"));
/* 55 */     nodes.add(new ClassTransformer.InstrSet(this, list, 208, ClassTransformer.InstrOpType.Replace));
/* 56 */     this.mcpMethodNodes.put("updateRenderer | ()V", new ClassTransformer.Patch(this, nodes, ClassTransformer.PatchOpType.Modify));
/*    */     
/* 58 */     nodes = new ArrayList<ClassTransformer.InstrSet>();
/* 59 */     list = new InsnList();
/*    */     
/* 61 */     list.add((AbstractInsnNode)new FieldInsnNode(180, "blt", "al", "Ljava/util/Random;"));
/* 62 */     list.add((AbstractInsnNode)new VarInsnNode(25, 0));
/* 63 */     list.add((AbstractInsnNode)new FieldInsnNode(180, "blt", "w", "I"));
/* 64 */     list.add((AbstractInsnNode)new MethodInsnNode(184, "com/bioxx/tfc/ClientOverrides", "doRainClient", "(Ljava/util/Random;I)V"));
/* 65 */     nodes.add(new ClassTransformer.InstrSet(this, list, 208, ClassTransformer.InstrOpType.Replace));
/* 66 */     this.obfMethodNodes.put("d | ()V", new ClassTransformer.Patch(this, nodes, ClassTransformer.PatchOpType.Modify));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ASM\Transform\TF_EntityRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */