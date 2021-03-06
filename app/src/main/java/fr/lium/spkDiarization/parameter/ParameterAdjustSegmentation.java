/**
 * <p>
 * ParameterAdjustSegmentation
 * </p>
 *
 * @author <activity_summary href="mailto:sylvain.meignier@lium.univ-lemans.fr">Sylvain Meignier</activity_summary>
 * @version v2.0
 * <p/>
 * Copyright (c) 2007-2009 Universite du Maine. All Rights Reserved. Use is subject to license terms.
 * <p/>
 * THIS SOFTWARE IS PROVIDED BY THE "UNIVERSITE DU MAINE" AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 * <p/>
 * not more use
 */

package fr.lium.spkDiarization.parameter;

import java.util.ArrayList;

import gnu.getopt.LongOpt;

public class ParameterAdjustSegmentation implements ParameterInterface {
    public static int ReferenceSeachDecay = -1;
    public static int ReferenceHalfWindowSizeForEnergie = -1;
    private int seachDecay;
    private int halfWindowSizeForEnergie;

    public ParameterAdjustSegmentation(ArrayList<LongOpt> list, Parameter param) {
        setSeachDecay(25);
        setHalfWindowSizeForEnergie(5);
        ReferenceSeachDecay = param.getNextOptionIndex();
        ReferenceHalfWindowSizeForEnergie = param.getNextOptionIndex();
        addOptions(list);
    }

    public boolean readParam(int option, String optarg) {
        if (option == ReferenceSeachDecay) {
            setSeachDecay(Integer.parseInt(optarg));
            return true;
        } else if (option == ReferenceHalfWindowSizeForEnergie) {
            setHalfWindowSizeForEnergie(Integer.parseInt(optarg));
            return true;
        }
        return false;
    }

    public void addOptions(ArrayList<LongOpt> list) {
        list.add(new LongOpt("sSeachDecay", 1, null, ReferenceSeachDecay));
        list.add(new LongOpt("sHalfWindowSizeForEnergie", 1, null, ReferenceHalfWindowSizeForEnergie));
    }

    public int getSeachDecay() {
        return seachDecay;
    }

    public void setSeachDecay(int adjSeachDecay) {
        this.seachDecay = adjSeachDecay;
    }

    public int getHalfWindowSizeForEnergie() {
        return halfWindowSizeForEnergie;
    }

    public void setHalfWindowSizeForEnergie(int adjHSizeWin) {
        this.halfWindowSizeForEnergie = adjHSizeWin;
    }

    public void printSeachDecay() {
        System.out.println("info[ParameterAdjustSegmentation] \t --sSeachDecay = " + getSeachDecay());
    }

    public void printHalfWindowSizeForEnergie() {
        System.out.println("info[ParameterAdjustSegmentation] \t --sHalfWindowSizeForEnergie = " + getHalfWindowSizeForEnergie());
    }
}