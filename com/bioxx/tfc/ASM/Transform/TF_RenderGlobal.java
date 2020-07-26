/*    */ package com.bioxx.tfc.ASM.Transform;
/*    */ 
/*    */ import com.bioxx.tfc.ASM.ClassTransformer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.InsnList;
/*    */ import org.objectweb.asm.tree.LabelNode;
/*    */ import org.objectweb.asm.tree.LineNumberNode;
/*    */ import org.objectweb.asm.tree.MethodInsnNode;
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
/*    */ public class TF_RenderGlobal
/*    */   extends ClassTransformer
/*    */ {
/*    */   public TF_RenderGlobal() {
/* 25 */     List<ClassTransformer.InstrSet> nodes = new ArrayList<ClassTransformer.InstrSet>();
/* 26 */     InsnList list = new InsnList();
/* 27 */     list.add((AbstractInsnNode)new LineNumberNode(445, new LabelNode()));
/* 28 */     list.add((AbstractInsnNode)new MethodInsnNode(184, "com/bioxx/tfc/ClientOverrides", "loadRenderers", "()V"));
/* 29 */     nodes.add(new ClassTransformer.InstrSet(this, list, 445, ClassTransformer.InstrOpType.InsertBefore));
/*    */     
/* 31 */     this.mcpMethodNodes.put("loadRenderers | ()V", new ClassTransformer.Patch(this, nodes, ClassTransformer.PatchOpType.Modify));
/* 32 */     this.obfMethodNodes.put("a | ()V", new ClassTransformer.Patch(this, nodes, ClassTransformer.PatchOpType.Modify));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ASM\Transform\TF_RenderGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */