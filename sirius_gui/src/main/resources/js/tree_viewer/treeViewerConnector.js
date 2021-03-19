function requestNewScores(){
    // placeholder for now, until it is decided how to handle scores
}

function getRescoredTree(json_tree){
    return connector.getRescoredTree(json_tree);
}

function formulaDiff(f1, f2){
    return connector.formulaDiff(f1, f2);
}

function formulaIsSubset(f1, f2){
    return connector.formulaIsSubset(f1, f2);
}

function getCommonLosses(){
    if (typeof variable !== 'undefined')
        return connector.getCommonLosses();
    else
        return [];
}

function isXmas(){
    return connector.getXmas();
}

function deactivateSpecial(){
    connector.deactivateSpecial();
    d3.selectAll('span').remove();
    reset();
}
