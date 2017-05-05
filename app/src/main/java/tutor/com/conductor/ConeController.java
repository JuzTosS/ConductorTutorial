package tutor.com.conductor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;

public class ConeController extends Controller {
    private int conesCount = 0;
    private TextView textField;

    public ConeController(int conesCount) {
        this.conesCount = conesCount;
        getArgs().putInt("conesCount", conesCount);
    }

    public ConeController(@Nullable Bundle args) {
        super(args);
        conesCount = args.getInt("conesCount");
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_cone, container, false);
        textField = (TextView) view.findViewById(R.id.textField);
        return view;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        textField.setText("Cones: " + conesCount);
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        textField = null;
    }

}
